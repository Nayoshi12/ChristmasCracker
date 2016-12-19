/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.redrield.christmascracker.commands

import org.bukkit.command.CommandSender


abstract class SubCommand(val name: String) {

    abstract fun execute(cs: CommandSender, args: Array<String>)
}
