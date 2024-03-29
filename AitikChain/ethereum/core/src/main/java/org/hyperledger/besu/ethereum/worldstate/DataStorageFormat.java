/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.hyperledger.besu.ethereum.worldstate;

public enum DataStorageFormat {
  FOREST(1), // Original format.  Store all tries
  BONSAI(2); // New format.  Store one trie, and trie logs to roll forward and backward.

  private final int databaseVersion;

  DataStorageFormat(final int databaseVersion) {
    this.databaseVersion = databaseVersion;
  }

  public int getDatabaseVersion() {
    return databaseVersion;
  }

  public static String getName(final int databaseVersion) {
    for (DataStorageFormat format : DataStorageFormat.values()) {
      if (format.getDatabaseVersion() == databaseVersion) {
        return format.name();
      }
    }
    return "Unknown";
  }
}
