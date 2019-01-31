/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.ledpixelart.piledriver;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/**
 * This class demonstrates the minimal client implementation of the
 * DownloaderService from the Downloader library.
 */
public class PIXELDownloaderService extends DownloaderService {
    // stuff for LVL -- MODIFY FOR YOUR APPLICATION!
    private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApsLmAQE124CI/5NjuahxzR8VPxV4QXmjgqwv7eM3jdW1BC5y1OSgJy5C2CcyN55Klta70Qp9gmOEs+f60OTcFeKN//BqHdZbairA+1q5eqEsPOIGBEdrrCQNLdXrZ6vdmX+csvLPoqfme647Bt6qdHpFfNBuspkFGQdUDdJD3Ppe5hjXm3hYGgmFN8vNbKB2NHO9Ue/iom2VQhHfImXlaAsq00LYX0ADe/2zrvMijLlqfHrqPeGc7sbq0VX7dJb4MHP6qM3k6dS+kAo2oX5lxXu+0N6Xsm6Ax1TEEj6kqs9xar21UfuFP4KtY6jmXVwRDEEqNW0RLWwsAh0lHozTZwIDAQAB";
    // used by the preference obfuscater
    private static final byte[] SALT = new byte[] {
            1, 43, -12, -1, 54, 98,
            -100, -12, 43, 2, -8, -4, 9, 5, -106, -108, -33, 45, -1, 84
    };

    /**
     * This public key comes from your Android Market publisher account, and it
     * used by the LVL to validate responses from Market on your behalf.
     */
    @Override
    public String getPublicKey() {
        return BASE64_PUBLIC_KEY;
    }

    /**
     * This is used by the preference obfuscater to make sure that your
     * obfuscated preferences are different than the ones used by other
     * applications.
     */
    @Override
    public byte[] getSALT() {
        return SALT;
    }

    /**
     * Fill this in with the class name for your alarm receiver. We do this
     * because receivers must be unique across all of Android (it's a good idea
     * to make sure that your receiver is in your unique package)
     */
    @Override
    public String getAlarmReceiverClassName() {
        return PIXELAlarmReceiver.class.getName();
    }

}
