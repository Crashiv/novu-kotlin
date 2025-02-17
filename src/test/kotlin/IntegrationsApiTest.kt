import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Credential
import co.novu.dto.request.IntegrationRequest
import co.novu.dto.response.IntegrationReponse
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.activeIntegrations
import co.novu.extensions.createIntegration
import co.novu.extensions.deleteIntegration
import co.novu.extensions.integrations
import co.novu.extensions.providerWebhook
import co.novu.extensions.updateIntegration
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class IntegrationsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetIntegrations() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                IntegrationReponse(
                    _id = "123",
                    _environmentId = "enviromentId",
                    _organizationId = "organizationId",
                    providerId = "providerId",
                    channel = "channel",
                    credential = Credential(
                        apiKey = "apiKey",
                        secretKey = "secretKey",
                        token = "token",
                        host = "host",
                        port = "port",
                        secure = true,
                        region = "region",
                        accountSid = "accountSid",
                        messageProfileId = "messageProfileId",
                        from = "from",
                        senderName = "senderName",
                        projectName = "projectName",
                        applicationId = "applicationId",
                        clientId = "clientId",
                        domain = "domain"
                    ),
                    active = true,
                    deleted = false
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.integrations()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/integrations")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testCreateIntegrations() = runTest {
        val responseBody = ResponseWrapper(
            IntegrationReponse(
                _id = "123",
                _environmentId = "enviromentId",
                _organizationId = "organizationId",
                providerId = "providerId",
                channel = "channel",
                credential = Credential(
                    apiKey = "apiKey",
                    user = "user",
                    password = "password",
                    secretKey = "secretKey",
                    token = "token",
                    host = "host",
                    port = "port",
                    secure = true,
                    region = "region",
                    accountSid = "accountSid",
                    messageProfileId = "messageProfileId",
                    from = "from",
                    senderName = "senderName",
                    projectName = "projectName",
                    applicationId = "applicationId",
                    clientId = "clientId",
                    domain = "domain"
                ),
                active = true,
                deleted = false
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = IntegrationRequest(
            providerId = "providerId",
            channel = "channel",
            credential = Credential(
                apiKey = "apiKey",
                user = "user",
                password = "password",
                secretKey = "secretKey",
                token = "token",
                host = "host",
                port = "port",
                secure = true,
                region = "region",
                accountSid = "accountSid",
                messageProfileId = "messageProfileId",
                from = "from",
                senderName = "senderName",
                projectName = "projectName",
                applicationId = "applicationId",
                clientId = "clientId",
                domain = "domain"
            ),
            active = true,
            check = true
        )
        val result = mockNovu.createIntegration(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/integrations")
        assert(request.method == "POST")
        assert(result == responseBody)
    }

    @Test
    fun testGetActiveIntegrations() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                IntegrationReponse(
                    _id = "123",
                    _environmentId = "enviromentId",
                    _organizationId = "organizationId",
                    providerId = "providerId",
                    channel = "channel",
                    credential = Credential(
                        apiKey = "apiKey",
                        user = "user",
                        password = "password",
                        secretKey = "secretKey",
                        token = "token",
                        host = "host",
                        port = "port",
                        secure = true,
                        region = "region",
                        accountSid = "accountSid",
                        messageProfileId = "messageProfileId",
                        from = "from",
                        senderName = "senderName",
                        projectName = "projectName",
                        applicationId = "applicationId",
                        clientId = "clientId",
                        domain = "domain"
                    ),
                    active = true,
                    deleted = false
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.activeIntegrations()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/integrations/active")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testGetProviderWebHook() = runTest {
        val responseBody = ResponseWrapper(true)

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val providerId = "providerId"
        val result = mockNovu.providerWebhook(providerId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/integrations/webhook/provider/$providerId/status")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testUpdateIntegration() = runTest {
        val responseBody = ResponseWrapper(
            IntegrationReponse(
                _id = "123",
                _environmentId = "enviromentId",
                _organizationId = "organizationId",
                providerId = "providerId",
                channel = "channel",
                credential = Credential(
                    apiKey = "apiKey",
                    user = "user",
                    password = "password",
                    secretKey = "secretKey",
                    token = "token",
                    host = "host",
                    port = "port",
                    secure = true,
                    region = "region",
                    accountSid = "accountSid",
                    messageProfileId = "messageProfileId",
                    from = "from",
                    senderName = "senderName",
                    projectName = "projectName",
                    applicationId = "applicationId",
                    clientId = "clientId",
                    domain = "domain"
                ),
                active = true,
                deleted = false
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

        val requestBody = IntegrationRequest(
            providerId = "providerId",
            channel = "channel",
            credential = Credential(
                apiKey = "apiKey",
                user = "user",
                password = "password",
                secretKey = "secretKey",
                token = "token",
                host = "host",
                port = "port",
                secure = true,
                region = "region",
                accountSid = "accountSid",
                messageProfileId = "messageProfileId",
                from = "from",
                senderName = "senderName",
                projectName = "projectName",
                applicationId = "applicationId",
                clientId = "clientId",
                domain = "domain"
            ),
            active = true,
            check = true
        )

        val integrationId = "integrationId"
        val result = mockNovu.updateIntegration(integrationId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/integrations/$integrationId")
        assert(request.method == "PUT")
        assert(result == responseBody)
    }

    @Test
    fun testDeleteIntegration() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                IntegrationReponse(
                    _id = "123",
                    _environmentId = "enviromentId",
                    _organizationId = "organizationId",
                    providerId = "providerId",
                    channel = "channel",
                    credential = Credential(
                        apiKey = "apiKey",
                        user = "user",
                        password = "password",
                        secretKey = "secretKey",
                        token = "token",
                        host = "host",
                        port = "port",
                        secure = true,
                        region = "region",
                        accountSid = "accountSid",
                        messageProfileId = "messageProfileId",
                        from = "from",
                        senderName = "senderName",
                        projectName = "projectName",
                        applicationId = "applicationId",
                        clientId = "clientId",
                        domain = "domain"
                    ),
                    active = true,
                    deleted = false
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val integrationId = "integrationId"
        val result = mockNovu.deleteIntegration(integrationId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/integrations/$integrationId")
        assert(request.method == "DELETE")
        assert(result == responseBody)
    }
}
