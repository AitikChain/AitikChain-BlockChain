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
package org.hyperledger.besu.tests.acceptance.bft;

import org.hyperledger.besu.tests.acceptance.dsl.node.BesuNode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BftZeroValidatorsAcceptanceTest extends ParameterizedBftTestBase {

  @ParameterizedTest(name = "{0} bft node factory type")
  @MethodSource("factoryFunctions")
  public void zeroValidatorsFormValidCluster(
      final String testName, final BftAcceptanceTestParameterization nodeFactory) throws Exception {
    setUp(testName, nodeFactory);
    final String[] validators = {};
    final BesuNode node1 = nodeFactory.createNodeWithValidators(besu, "node1", validators);
    final BesuNode node2 = nodeFactory.createNodeWithValidators(besu, "node2", validators);

    cluster.start(node1, node2);

    cluster.verify(net.awaitPeerCount(1));
  }
}
