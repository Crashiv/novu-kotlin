package co.novu

import co.novu.api.ChangesApi
import co.novu.api.EnvironmentsApi
import co.novu.api.EventsApi
import co.novu.api.ExecutionDetailsApi
import co.novu.api.FeedsApi
import co.novu.api.InboundParseApi
import co.novu.api.IntegrationsApi
import co.novu.api.LayoutsApi
import co.novu.api.MessagesApi
import co.novu.api.NotificationGroupsApi
import co.novu.api.NotificationTemplatesApi
import co.novu.api.NotificationsApi
import co.novu.api.SubscribersApi
import co.novu.api.TopicsApi
import co.novu.helpers.RetrofitHelper

data class NovuConfig(
    var backendUrl: String = "https://api.novu.co/v1/",
    var apiKey: String = ""
)

class Novu(
    config: NovuConfig
) {

    constructor(apiKey: String) : this(NovuConfig(apiKey = apiKey))

    private val retrofitInstance = RetrofitHelper(config).getInstance()

    internal val eventsApi = retrofitInstance.create(EventsApi::class.java)

    internal val subscribersApi = retrofitInstance.create(SubscribersApi::class.java)

    internal val topicsApi = retrofitInstance.create(TopicsApi::class.java)

    internal val changesApi = retrofitInstance.create(ChangesApi::class.java)

    internal val integrationsApi = retrofitInstance.create(IntegrationsApi::class.java)

    internal val executionDetailsApi = retrofitInstance.create(ExecutionDetailsApi::class.java)

    internal val feedsApi = retrofitInstance.create(FeedsApi::class.java)

    internal val messagesApi = retrofitInstance.create(MessagesApi::class.java)

    internal val notificationsApi = retrofitInstance.create(NotificationsApi::class.java)

    internal val environmentsApi = retrofitInstance.create(EnvironmentsApi::class.java)

    internal val layoutsApi = retrofitInstance.create(LayoutsApi::class.java)

    internal val notificationTemplatesApi = retrofitInstance.create(NotificationTemplatesApi::class.java)

    internal val notificationGroupsApi = retrofitInstance.create(NotificationGroupsApi::class.java)

    internal val inboundParseApi = retrofitInstance.create(InboundParseApi::class.java)
}