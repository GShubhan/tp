# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* **Elf**: A system entity representing a staff member or volunteer.
* **Child**: A system entity representing a recipient or target user.
* **CLI**: Command Line Interface; an interface where users type commands to interact with the software.
* **Index**: A unique numerical identifier assigned to an item in the current displayed list.

## Instructions for manual testing

#### Initial Launch
1. Download the `.jar` file and place it in an empty folder.
2. Run `java -jar duke.jar`. The GUI should load with a sample message.

#### Testing Elf Commands
1. **Adding:** Type `elf n/Buddy`. Verify "Buddy" appears in the `elflist`.
2. **Editing:** Type `Editelf e/1 n/Dobby`. Verify the first Elf's name changes to "Dobby".
3. **Deleting:** Type `rmelf e/1`. Verify the Elf is removed.

#### Testing Find Functionality
1. Ensure you have children data loaded (use `childlist` to check).
2. Type `find l/Singapore`.
3. **Expected Result:** Only children with the location "Singapore" are displayed in the list.
