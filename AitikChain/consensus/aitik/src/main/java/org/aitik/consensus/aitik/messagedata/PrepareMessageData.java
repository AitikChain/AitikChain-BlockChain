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
 */
package org.aitik.consensus.aitik.messagedata;

import org.hyperledger.besu.consensus.common.bft.messagedata.AbstractBftMessageData;
import org.aitik.consensus.aitik.messagewrappers.Prepare;
import org.hyperledger.besu.ethereum.p2p.rlpx.wire.MessageData;

import org.apache.tuweni.bytes.Bytes;

/** The Prepare message data. */
public class PrepareMessageData extends AbstractBftMessageData {

  private static final int MESSAGE_CODE = Aitik.PREPARE;

  private PrepareMessageData(final Bytes data) {
    super(data);
  }

  /**
   * Gets prepare message data from message data.
   *
   * @param messageData the message data
   * @return the prepare message data
   */
  public static PrepareMessageData fromMessageData(final MessageData messageData) {
    return fromMessageData(
        messageData, MESSAGE_CODE, PrepareMessageData.class, PrepareMessageData::new);
  }

  /**
   * Decode.
   *
   * @return the prepare
   */
  public Prepare decode() {
    return Prepare.decode(data);
  }

  /**
   * Create prepare message data.
   *
   * @param preapare the Prepare
   * @return the prepare message data
   */
  public static PrepareMessageData create(final Prepare preapare) {
    return new PrepareMessageData(preapare.encode());
  }

  @Override
  public int getCode() {
    return MESSAGE_CODE;
  }
}
