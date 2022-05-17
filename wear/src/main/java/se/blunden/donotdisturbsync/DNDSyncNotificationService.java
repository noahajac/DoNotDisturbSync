/*
 * Copyright (C) 2017-2022 blunden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package se.blunden.donotdisturbsync;

import android.service.notification.NotificationListenerService;

/**
 * A {@link NotificationListenerService} service needed to listen for DND state changes.
 *
 * Also allows users to add the app as a notification listener which
 * automatically grants and enables android.permission.ACCESS_NOTIFICATION_POLICY
 * that can't be enabled the normal way on Android Wear 2.0 and Wear OS.
 */
public class DNDSyncNotificationService extends NotificationListenerService {}
