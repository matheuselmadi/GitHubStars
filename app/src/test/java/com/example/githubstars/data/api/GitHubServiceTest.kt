package com.example.githubstars.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubServiceTest {
    private lateinit var service: GitHubService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getRepositories_sendRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("testresponse.json")
            val responseBody = service.getRepositories("language:kotlin", "stars", 1)
            assertThat(responseBody).isNotNull()
        }
    }

    @Test
    fun getRepositories_sendRequest_correctPathConstruction() {
        runBlocking {
            enqueueMockResponse("testresponse.json")
            service.getRepositories("language:kotlin", "stars", 1)
            val request = server.takeRequest()
            assertThat(request.path).isEqualTo("/search/repositories?q=language%3Akotlin&sort=stars&page=1")
        }
    }

    @Test
    fun getRepositories_receivedResponse_CorrectPageSize() {
        runBlocking {
            enqueueMockResponse("testresponse.json")
            val responseBody = service.getRepositories("language:kotlin", "stars", 1)
            val items = responseBody.body()!!.items
            assertThat(items.size).isEqualTo(30)
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
