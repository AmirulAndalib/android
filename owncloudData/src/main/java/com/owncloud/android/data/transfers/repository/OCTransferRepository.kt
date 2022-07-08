/**
 * ownCloud Android client application
 *
 * @author Juan Carlos Garrote Gascón
 *
 * Copyright (C) 2022 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.owncloud.android.data.transfers.repository

import com.owncloud.android.data.transfers.datasources.LocalTransferDataSource
import com.owncloud.android.domain.transfers.TransferRepository
import com.owncloud.android.domain.transfers.model.OCTransfer

class OCTransferRepository(
    private val localTransferDataSource: LocalTransferDataSource
): TransferRepository {
    override fun storeTransfer(transfer: OCTransfer) =
        localTransferDataSource.storeTransfer(transfer = transfer)

    override fun updateTransfer(transfer: OCTransfer) =
        localTransferDataSource.updateTransfer(transfer = transfer)

    override fun removeTransferById(id: Long) =
        localTransferDataSource.removeTransferById(id = id)

    override fun removeAllTransfersFromAccount(accountName: String) =
        localTransferDataSource.removeAllTransfersFromAccount(accountName = accountName)

    override fun getAllTransfers(): List<OCTransfer> =
        localTransferDataSource.getAllTransfers()

    override fun getLastTransferFor(remotePath: String, accountName: String) =
        localTransferDataSource.getLastTransferFor(remotePath = remotePath, accountName = accountName)

    override fun getCurrentAndPendingTransfers() =
        localTransferDataSource.getCurrentAndPendingTransfers()

    override fun getFailedTransfers() =
        localTransferDataSource.getFailedTransfers()

    override fun getFinishedTransfers() =
        localTransferDataSource.getFinishedTransfers()

    override fun clearFailedTransfers() =
        localTransferDataSource.clearFailedTransfers()

    override fun clearSuccessfulTransfers() =
        localTransferDataSource.clearSuccessfulTransfers()
}