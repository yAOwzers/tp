# Developer Guide

- [Introduction](#introduction)
- [Setting up](#setting-up)
    - [Prerequisites](#prerequisites)
    - [Setting up the project in your computer](#setting-up-the-project-in-your-computer)
    - [Verifying the setup](#verifying-the-setup)
    - [Configure coding style](#configure-the-coding-style)
- [Design](#design)
    - [Architecture](#architecture)
- [Implementation](#implementation)
- [Documentation](#documentation)
    - [Setting up and maintaining the project website](#setting-up-and-maintaining-the-project-website)
    - [Style guidance](#style-guidance)
    - [Diagrams](#diagrams)
    - [Converting a document to the PDF Format](#converting-a-document-to-the-pdf-format)
- [Testing](#testing)
    - [Running tests](#running-tests)
    - [Types of tests](#types-of-tests)
- [Appendix A: Requirements](#appendix-a-requirements)
    - [Project Scope](#project-scope)
    - [User Stores](#user-stories)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Glossary](#glossary)
- [Appendix B: Instructions for manual testing](#appendix-b-instructions-for-manual-testing)

## Introduction

## Setting up

### Prerequisites

1. **JDK** 11
2. **IntelliJ** IDEA

### Setting up the project in your computer

>:exclamation: **Caution:** Follow the steps in the following guide precisely.
>Things will not work out if you deviate in some steps.
1. **Fork** this repo, and **clone** the fork into your computer.
2. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first).
3. Set up the correct JDK version for Gradle
    a. Click `Configure` > `Project Defaults` > `Project Structure`
    b. Click `New...` and find the directory of the JDK.
4. Click `Import Project`
5. Locate the `build.gradle` file and select it. Click `OK`.
6. Click `Open as Project`.
7. Click `OK` to accept the default settings.

### Verifying the setup

1. Run the `seedu.duke.Duke`.
2. Try a few commands.
3. [Run the tests](#running-tests) to ensure they all pass.

### Configure the coding style

If using IDEA, follow the guide [[se-edu/guides] IDEA: Configuring the code style](https://se-education.org/guides/tutorials/intellijCodeStyle.html)
to set up IDEA’s coding style to match ours.

>Optionally, you can follow the guide [[se-edu/guides] Using Checkstyle](https://se-education.org/guides/tutorials/checkstyle.html)
>to find how to use the CheckStyle within IDEA e.g., to report problems as you write code.

## Design

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Architecture

#### Commands

![UML diagram for Timetable Commands](/diagrams/class/jpeg/timetable_commands.jpg)

![UML diagrams for Notebook Commands](/diagrams/class/jpeg/notebook_commands.jpg)

#### Notebooks

![UML diagram for Notebooks](/diagrams/class/jpeg/notebooks.jpg)

#### Tasks

**How the architecture components interact with each other**
The Sequence Diagram below shows how the components interact with each other for the scenario...

## Implementation

This section describes some noteworthy details on how certain features are implemented.

### [Proposed] Find duplicate feature

#### Proposed implementation

The proposed find duplicate function is facilitated by a method in the classes `Task List`, `Notebook Shelf`, `Notebook` and `Section`.

Given below is an example usage scenario and how the find duplicates function behaves.

Step 1. The user launches the application for the first time. CliUserInterface#executeCommand is called when the user adds a task into the task list.

Step 2. The user types `add /tTask /by19-10-2020 1900`. The `add` command is passed through `InputParser#getCommandFromInput`, which then calls `AddCommandTimetableMode#execute()`.

Step 3. `execute()` is called, which then calls `InputParser#parseTaskTitle`, which first extracts the `title` from the user's input.

Step 4. The `title` is then passed to the `findDuplicate` method in `TaskList`.

Step 5. The `findDuplicate` method returns false, since it is the first task titled `Task` to be added into the `TaskList`. Conversely, the `findDuplicate` method returns true when a task with the same `title` already exists in the `TaskList`.

Step 6. `InputParser#parseDeadline` is then called, which returns the `deadline` to `AddCommandTimetableMode#execute()`.

Step 7. `TaskList#addTask` is then called and a new `Task`, with `title` and `deadline`, is initialised.

Step 8. To signal that the user has successfully added a task, a message is printed with `CliMessages#printAddedTaskMessage`.


The sequence diagram below shows how the find duplicate command works:

![Sequence diagram for finding duplicates](/diagrams/class/jpeg/duplicates_francene.jpg)

#### Design consideration
##### Aspect: Where findDuplicate should be placed

* Alternative 1 (current choice): findDuplicate should be saved in the class that potentially creates duplicates.
  * Pros: Easier to access previously saved tasks/notebooks/notebook sections.
  * Cons: May have performance issues in terms of memory usage.
* Alternative 2: findDuplicate should be saved in the command that creates it.
  * Pros: Less time spent in passing variables to different classes.
  * Cons: We must grant access to private objects that are not within the command class.


## Documentation

We use Markdown for writing our documents.

### Setting up and maintaining the project website.

- We use **Jekyll** to manage documentation.
- The `docs/` folder is used for documentation.
- To learn how to set it up and maintain the project website, follow the guide
[[se-edu/guides] Using Jekyll for project documentation](https://se-education.org/guides/tutorials/jekyll.html).

### Style guidance

- Follow the [Google developer documentation style guide](https://developers.google.com/style).
- Also relevant is the [[se-edu/guides] Markdown coding standard](https://se-education.org/guides/conventions/markdown.html).

### Diagrams

We use Microsoft Visio Professional 2019 to draw our UML diagrams.

### Converting a document to the PDF Format

We use **Chrome** for converting documentation to PDF format.
> Reason: Chrome's PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
2. Within Chrome, click on the `Print` option in Chrome’s menu.
3. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format.
For best results, use the settings indicated in the screenshot below.

<img src= "https://se-education.org/guides/tutorials/images/chrome_save_as_pdf.png">

## Testing

### Running tests

There are two ways to run tests.
- **Method 1: Using IntelliJ JUnit test runner**
    - To run all tests, right-click on the `src/test/java` and choose `Run 'Tests in tp.test'`
    - To run a subset of tests, you can right-click on a test package, test class, or a test and choose `Run 'ABC'`.
- **Method 2: Using Gradle**
    - Open a console and run the command `gradlew clean test` (Mac/Linux: `./gradlew clean test`)

### Types of tests

{Describe the type of testing used in the code}
This project has one type of test:
Unit tests targeting the lowest level methods/classes.
e.g. `seedu.duke.userinterface.command.AddNotebookTest`

## Appendix A: Requirements

### Project Scope
**Target user profile**
- student with multiple courses
- has a need to multiple notes
- has a need to view upcoming tasks swiftly
- prefer desktop apps over other forms
- is reasonably comfortable using CLI apps

**Value proposition**:manage both tasks and notes faster and lighter than a typical mouse/GUI driven app

### User Stories

Priorities: High (must have) - `***`, Medium (nice to have) - `**`, Low (unlikely to have) - `*`

|Priority| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|`***`|user|record and save my notes|review them later|
|`***`|student|view all tasks and sections of my notebook|have a clear view of my progress|
|`***`|new user|have usage instructions|refer to instructions when I forget how to use the App|
|`**`|forgetful user|see the most urgent tasks|prioritise my tasks|
|`*`|long-time user|have personalised messages|feel attached to my notes|

### Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

### Glossary

* **Mainstream OS**: Windows, Linux, OS-X
* **Notebook shelf**: a list of all notebooks entered by the user

## Appendix B: Instructions for manual testing

Given below are instructions to test the app manually.
>**Note**: These instructions only provide a starting point for testers to work on;
>testers are expected to do more *exploratory* testing.

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
