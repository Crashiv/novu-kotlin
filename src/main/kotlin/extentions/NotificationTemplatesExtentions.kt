package co.novu.extentions

import co.novu.Novu
import co.novu.dto.response.NotificationTemplates
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getNotificationTemplates(page: BigInteger, limit: BigInteger) = runBlocking {
    val response = notificationTemplatesApi.getNotificationTemplates(page, limit)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.createNotificationTemplates(request: NotificationTemplates) = runBlocking {
    val response = notificationTemplatesApi.createNotificationTemplates(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateNotificationTemplates(templateId: String, request: NotificationTemplates) = runBlocking {
    val response = notificationTemplatesApi.updateNotificationTemplates(templateId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.deleteNotificationTemplate(templateId: String) = runBlocking {
    val response = notificationTemplatesApi.deleteNotificationTemplate(templateId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getNotificationTemplate(templateId: String) = runBlocking {
    val response = notificationTemplatesApi.getNotificationTemplate(templateId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateNotificationTemplateStatus(templateId: String, request: co.novu.dto.request.UpdateNotificationTemplateStatusRequest) = runBlocking {
    val response = notificationTemplatesApi.updateNotificationTemplateStatus(templateId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
