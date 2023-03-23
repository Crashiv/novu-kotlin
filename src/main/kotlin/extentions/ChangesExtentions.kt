package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getChanges(page: BigInteger? = null, limit: BigInteger? = null, promoted: String? = null) = runBlocking {
    val response = changesApi.getChanges(page, limit, promoted)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
fun Novu.getChangesCount() = runBlocking {
    val response = changesApi.getChangesCount()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
fun Novu.applyChanges() = runBlocking {
    val response = changesApi.applyChanges()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.applychange(changeId: String) = runBlocking {
    val response = changesApi.applyChange(changedId = changeId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
