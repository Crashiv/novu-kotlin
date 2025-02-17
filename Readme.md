# Novu Kotlin SDK

> The [Novu Kotlin](https://novu.co) SDK provides a fluent and expressive interface for interacting with [Novu's API](https://api.novu.co/api) and managing notifications.

## Installation

**Maven users:**

```xml
//Add sonatype release repositories
<repositories>
    ...
    <repository>
        <id>sonatype</id>
        <url>https://s01.oss.sonatype.org/content/repositories/releases/</url> // for release
        or 
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url> // for snapshot
    </repository>
</repositories>

// add dependency
<dependency>
    <groupId>io.github.crashiv</groupId>
    <artifactId>novu-kotlin</artifactId>
    <version>0.1.1-SNAPSHOT</version>
</dependency>
```
Then run `mnv install`.


**Gradle users:**

```gradle
//Add sonatype release repositories
repositories {
    ...
    maven { url "https://s01.oss.sonatype.org/content/repositories/releases/" }
}

// add dependency
implementation("io.github.crashiv:novu-kotlin:0.1.1-SNAPSHOT")
```
then run `gradlew build`


## Usage

To use the library, first initialize the client with your API token:

```kotlin
// without changing the backend URL
import co.novu.Novu
import co.novu.extentions.environments

fun main() {
    val novu = Novu(apiKey = "API_KEY")
    val environment = novu.environments()
    println(environment)
}

```
```kotlin
// with config param
import co.novu.Novu
import co.novu.NovuConfig
import co.novu.extentions.environments

fun main() {
    val config = NovuConfig(backendUrl = "http://localhost:8080/v1/", apiKey = "API_KEY")
    val novu = Novu(config)
    val environment = novu.environments()
    println(environment)
} 
```

You can then call methods on the client to interact with the Novu API:

```kotlin
novu.subscribers()
```

## List of all methods

The client methods map directly to the Novu API endpoints. Here is a list of all the available methods. Check [the API docs](https://docs.novu.co/api/overview) for list of available `methods`.

### Changes

- `changes(query = {})`
- `countChanges()`
- `applyBulkChanges()`
- `applyChange(changeId)`

### Environments

- `currentEnvironment()`
- `createEnvironment(body)`
- `environments()`
- `updateEnvironment(environmentId, body)`
- `apiKeys()`
- `regenerateApiKeys()`
- `updateWidgetSettings(body)`

### Events

- `triggerEvent(body)`
- `triggerBulkEvent(body)`
- `broadcastEvent(body)`
- `cancelTriggeredEvent(transactionId)`

### Execution Details

- `executionDetails(query = {})`

### Feeds

- `createFeed(body)`
- `feeds()`
- `deleteFeed(feedId)`

### Inbound Parse

- `validateMxRecordSetupForInboundParse()`

### Integrations

- `integrations()`
- `createIntegration(body)`
- `activeIntegrations()`
- `webhookProviderStatus(providerId)`
- `updateIntegration(integrationId, body)`
- `deleteIntegration(integrationId)`
- `channelLimit(channelType)`
- `inAppStatus()`

### Layouts

- `createLayout(body) `
- `layouts(query = {})`
- `layout(layoutId)`
- `deleteLayout(layoutId)`
- `updateLayout(layoutId, body)`
- `makeDefaultLayout(layoutId)`

### Messages

- `messages(query = {})`
- `deleteMessage(messageId)`

### Notification Groups

- `createNotificationGroup(body)`
- `notificationGroups()`

### Notification Templates

- `notificationTemplates(query = {})`
- `createNotificationTemplate(body)`
- `updateNotificationTemplate(templateId, body)`
- `deleteNotificationTemplate(templateId)`
- `notificationTemplate(templateId)`
- `notificationTemplateBlueprint(templateId)`
- `createNotificationTemplateBlueprint(templateId)`
- `updateNotificationTemplateStatus(templateId, body)`

### Notification

- `notifications(query = {})`
- `notificationsStats()`
- `notificationsGraphStats(query = {})`
- `notification(notificationId)`

### Subscribers

- `subscribers(query = {}) `
- `createSubscriber(body)`
- `subscriber(subscriberId)`
- `updateSubscriber(subscriberId, body)`
- `deleteSubscriber(subscriberId)`
- `updateSubscriberCredentials(subscriberId, body)`
- `updateSubscriberOnlineStatus(subscriberId, body)`
- `subscriberPreferences(subscriberId)`
- `updateSubscriberPreference(subscriberId, templateId, body)`
- `subscriberNotificationFeed(subscriberId, query = {})`
- `subscriberUnseenNotificationCount(subscriberId, query = {})`
- `markSubscriberFeedSeen(subscriberId, body)`
- `markMessageActionSeen(subscriberId, messageId, type)`

### Topics

- `createTopic(body)`
- `topics(query = {})`
- `addSubscribers(topicKey, body)`
- `removeSubscribers(topicKey, body)`
- `topic(topicKey)`
- `renameTopic(topicKey, body)`

### For more information about these methods and their parameters, see the [API documentation](https://docs.novu.co/api/overview).

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/novuhq/novu-kotlin
