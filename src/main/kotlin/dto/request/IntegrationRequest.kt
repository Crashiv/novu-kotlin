package co.novu.dto.request

import co.novu.dto.Credential

data class IntegrationRequest(
    var providerId: String,
    var channel: String,
    var credential: Credential,
    var active: Boolean,
    var check: Boolean
)
