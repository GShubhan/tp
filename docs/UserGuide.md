# User Guide

## Introduction

**ElfManager** is a specialized CLI tool designed for efficient tracking and organization of "Elves" and "Children" data. Built for speed and reliability, it allows users to manage complex personnel assignments and location-based data through a clean command-line interface.

## Quick Start

1. Ensure that you have **Java 17** or above installed on your computer.
2. Download the latest version of `Duke` from [here](http://link.to/duke).
3. Open your terminal, navigate to the folder where the file is located, and run the command: `java -jar duke.jar`.

## Features

### Action Tracking

#### Adding an action: `action`
Records a good or bad action for a child with a severity score.

* Format: `action CHILD_INDEX a/ACTION s/SEVERITY`
* SEVERITY must be an integer between -5 and 5
* Positive severity = good action, Negative severity = bad action
* Cannot add actions after `finalize` has been called

Examples:
* `action 1 a/helped grandma s/2`
* `action 2 a/broke window s/-3`

### Nice and Naughty Lists

#### Viewing the nice list: `nice`
Displays all children with a total action score >= 0.

* Format: `nice`

#### Viewing the naughty list: `naughty`
Displays all children with a total action score < 0.

* Format: `naughty`

#### Reassigning a child: `reassign`
Manually overrides a child's list assignment to either nice or naughty.
This override takes priority over the score-based classification.
Cannot reassign after `finalize` has been called.

* Format: `reassign CHILD_INDEX l/LIST`
* LIST must be either `nice` or `naughty`

Examples:
* `reassign 1 l/nice`
* `reassign 2 l/naughty`

### Finalizing Lists

#### Finalizing the lists: `finalize`
Freezes the nice and naughty lists. Once finalized:
* No more actions can be added
* No more reassignments can be made
* Gift allocation is now enabled

* Format: `finalize` or `finalise`

### Todo List

#### Adding a todo: `todo`
Adds a task with a deadline to Santa's todo list.
Todos due within the next 7 days are shown as reminders on startup.

* Format: `todo d/DESCRIPTION by/YYYY-MM-DD`
* Deadline must not be in the past
* Description cannot be empty

Examples:
* `todo d/Buy wrapping paper by/2026-12-20`
* `todo d/Pack gifts by/2026-12-24`

#### Viewing all todos: `todolist`
Displays all todos with their deadlines.

* Format: `todolist`

#### Removing a todo: `removetodo`
Removes a todo from the list by its index.

* Format: `removetodo INDEX`

Examples:
* `removetodo 1`


### Elf Management

#### Adding an Elf: `elf`
Adds a new Elf to the system records.
* Format: `elf n/NAME`
* Example: `elf n/Buddy`

#### Removing an Elf: `rmelf`
Removes an existing Elf based on their index in the list.
* Format: `rmelf e/ELF_INDEX`
* Example: `rmelf e/1`

#### Editing an Elf: `Editelf`
Updates the name of an existing Elf identified by their index.
* Format: `Editelf e/ELF_INDEX n/ELF_NEW_NAME`
* Example: `Editelf e/1 n/Legolas`

### Listing Entities

#### Listing Children: `childlist`
Displays a complete list of all children currently in the database.

#### Listing Elves: `elflist`
Displays a complete list of all elves currently in the database.

### Finding Children

#### Finding by Name: `find n/`
Searches for children matching the specified name.
* Format: `find n/NAME`
* Example: `find n/James Jake`

#### Finding by Age: `find a/`
Searches for children who match a specific age.
* Format: `find a/AGE`
* Example: `find a/11`

#### Finding by Location: `find l/`
Searches for children based on their registered location.
* Format: `find l/LOCATION`
* Example: `find l/Singapore`

#### Add gift: gift
Assigns a single gift or multiple gifts at a time to a child.
* Format: gift CHILD_INDEX g/GIFT
1. Assigns gifts to children according to the specified CHILD_INDEX. The index refers to the index number shown in the displayed child list. The index must be a positive integer 1, 2, 3, …​
*Examples:
gift 1 g/toy g/chocolate g/book
gift 3 g/book

#### Remove gift: degift
Removes gift/s assigned to a child.
* Format: degift CHILD_INDEX GIFT_INDEX...
1. The user inputs the child index and gift index.
2. Removes the gift from the gift list using the input child index and gift index. 
3. The index must be a positive integer 1, 2, 3..
* Examples:
degift 1 2


#### Update delivery status: delivery_status
Assigns delivery status of gifts as delivered/undelivered.
* Format: delivery_status CHILD_INDEX GIFT_INDEX d/delivery_status
1. The user inputs the child index, gift index and delivery status.
2. Assigns delivery status (delivered/undelivered) to a gift in the gift list based on the input child index and gift index. 
3. The index must be a positive integer 1, 2, 3
* Examples:
deliver 1 2 delivered

#### View gift list: giftlist
Displays all gifts assigned to children.
* Format: giftlist
* Examples: giftlist 
Displays the following:
toy
book

#### Mark gift as prepared: prepared
Marks a gift which is prepared but not delivered yet.
* Format: prepared CHILD_INDEX GIFT_INDEX
1. The user inputs the child index, gift index
2. The index must be a positive integer 1, 2, 3
* Examples
prepared 1 2

#### Storage
Stores data in a txt file which allows retrieval of lists upon restarting the application.

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: All your data is automatically saved in a local `data` folder within the same directory as the `.jar` file. Simply copy the entire folder and the `.jar` file to the new computer to resume where you left off.

## Command Summary

| Action                     | Format                                              | Example                           |
|:---------------------------|:----------------------------------------------------|:----------------------------------|
| **Add Elf**                | `elf n/NAME`                                        | `elf n/Dobby`                     |
| **Remove Elf**             | `rmelf e/INDEX`                                     | `rmelf e/1`                       |
| **Edit Elf**               | `Editelf e/INDEX n/NEW_NAME`                        | `Editelf e/2 n/Zobby`             |
| **List Children**          | `childlist`                                         | `childlist`                       |
| **List Elves**             | `elflist`                                           | `elflist`                         |
| **Find by Name**           | `find n/NAME`                                       | `find n/James Jake`               |
| **Find by Age**            | `find a/AGE`                                        | `find a/11`                       |
| **Find by Location**       | `find l/LOCATION`                                   | `find l/Singapore`                |
| **Add Gift**               | `gift CHILD_INDEX [g/GIFT]`                         | `gift 1 g/toy`                    |
| **Remove gift**            | `degift CHILD_INDEX GIFT_INDEX`                     | `degift 1 2`                      |
| **Update delivery status** | `delivery_status CHILD_INDEX GIFT_INDEX d/[status]` | `delivery_status 1 2 d/delivered` |
| **Mark prepared gift **    | `prepared CHILD INDEX GIFT INDEX`                   | `prepared 1 2`                    |
| **view giftlist**          | `giftlist`                                          | `giftlist`                        |
| **Add action**    | `action CHILD_INDEX a/ACTION s/SEVERITY` | `action 1 a/helped grandma s/2` |
| **View nice list** | `nice`                                  | `nice`                          |
| **View naughty list** | `naughty`                            | `naughty`                       |
| **Reassign child** | `reassign CHILD_INDEX l/LIST`           | `reassign 1 l/nice`             |
| **Finalize lists** | `finalize`                              | `finalize`                      |
| **Add todo**      | `todo d/DESCRIPTION by/YYYY-MM-DD`      | `todo d/Buy gifts by/2026-12-20`|
| **View todos**    | `todolist`                              | `todolist`                      |
| **Remove todo**   | `removetodo INDEX`                      | `removetodo 1`                  |