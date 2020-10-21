# Developer Guide

[1. Introduction](#1-introduction) <br>
[2. Setting up](#2-setting-up) <br>
&nbsp;&nbsp;[2.1. Prerequisites](#21-prerequisites) <br>
&nbsp;&nbsp;[2.2. Setting up the project in your computer](#22-setting-up-the-project-in-your-computer) <br>
&nbsp;&nbsp;[2.3. Verifying the setup](#23-verifying-the-setup) <br>
&nbsp;&nbsp;[2.4. Configure coding style](#24-configure-the-coding-style) <br>
[3. Design](#3-design) <br>
&nbsp;&nbsp;[3.1. Architecture](#31-architecture) <br>
&nbsp;&nbsp;[3.2. Commands](#32-commands) <br>
&nbsp;&nbsp;[3.3. Notebooks](#33-notebooks) <br>
&nbsp;&nbsp;[3.4. Tasks](#34-tasks) <br>
[4. Implementation](#4-implementation) <br>
&nbsp;&nbsp;[4.1. Mode Switch Feature](#41-mode-switch-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp[4.1.1. Implementation](#411-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.1.2. Design Considerations](#412-design-considerations) <br>
&nbsp;&nbsp;[4.2. Timetable Mode](#42-timetable-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1. Tasklist Management Feature](#421-tasklist-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2. List Feature](#421-tasklist-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;[4.3. Notebook Mode](#43-notebook-mode) <br>
[5. Documentation](#5-documentation) <br>
&nbsp;&nbsp;[5.1. Setting up and maintaining the project website](#51-setting-up-and-maintaining-the-project-website) <br>
&nbsp;&nbsp;[5.2. Style guidance](#52-style-guidance) <br>
&nbsp;&nbsp;[5.3. Diagrams](#53-diagrams) <br>
&nbsp;&nbsp;[5.4. Converting a document to the PDF Format](#54-converting-a-document-to-the-pdf-format) <br>
[6. Testing](#6-testing) <br>
&nbsp;&nbsp;[6.1. Running tests](#61-running-tests) <br>
&nbsp;&nbsp;[6.2. Types of tests](#62-types-of-tests) <br>
[Appendix A: Project Scope](#appendix-a-project-scope) <br>
[Appendix B: User Stores](#appendix-b-user-stories) <br>
[Appendix C: Use Cases](#appendix-c-use-cases) <br>
[Appendix D: Non-Functional Requirements](#appendix-d-non-functional-requirements) <br>
[Appendix E: Glossary](#appendix-e-glossary) <br>
[Appendix F: Instructions for manual testing](#appendix-f-instructions-for-manual-testing) <br>

## 1. Introduction
Zer0Note is a note taking and organisation application that combines the ease of use and feature set of graphical tools with the interaction speed of command-line based tools like vim and emacs.

## 2. Setting up

### 2.1. Prerequisites

1. **JDK** 11
2. **IntelliJ** IDEA

### 2.2. Setting up the project in your computer

>:exclamation: **Caution:** Follow the steps in the following guide precisely.
>Things will not work out if you deviate in some steps.
1. Fork this repo, and clone the fork into your computer.
2. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first).
3. Set up the correct JDK version for Gradle
    a. Click `Configure` > `Project Defaults` > `Project Structure`
    b. Click `New...` and find the directory of the JDK.
4. Click `Import Project`
5. Locate the `build.gradle` file and select it. Click `OK`.
6. Click `Open as Project`.
7. Click `OK` to accept the default settings.

### 2.3. Verifying the setup

1. Run the `seedu.duke.Duke`.
2. Try a few commands.
3. [Run the tests](#61-running-tests) to ensure they all pass.

### 2.4. Configure the coding style

If using IDEA, follow the guide [[se-edu/guides] IDEA: Configuring the code style](https://se-education.org/guides/tutorials/intellijCodeStyle.html) 
to set up IDEA’s coding style to match ours.

>Optionally, you can follow the guide [[se-edu/guides] Using Checkstyle](https://se-education.org/guides/tutorials/checkstyle.html) 
>to find how to use the CheckStyle within IDEA e.g., to report problems as you write code.

## 3. Design

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### 3.1 Architecture

#### 3.2 Commands

<img src="https://github.com/NeilBaner/tp/blob/neilbaner-dg/docs/diagrams/class/jpeg/timetable_commands.jpg">

<img src="https://github.com/NeilBaner/tp/blob/neilbaner-dg/docs/diagrams/class/jpeg/notebook_commands.jpg">

#### 3.3 Notebooks

<img src="https://github.com/NeilBaner/tp/blob/neilbaner-dg/docs/diagrams/class/jpeg/notebooks.jpg">

#### 3.4. Tasks

**How the architecture components interact with each other**
The Sequence Diagram below shows how the components interact with each other for the scenario...

## 4. Implementation
This section describes some noteworthy details on how certain features are implemented.

### 4.1. Mode Switch Feature

#### 4.1.1. Implementation

#### 4.1.2. Design Considerations

### 4.2. Timetable Mode

#### 4.2.1. Tasklist Management Feature

##### 4.2.1.1. Implementation
`TaskList` is implemented to manage and store the tasks input by the user. It comprises of a list of `Task`s.

This means that multiple operations such as addition and deletion can be done on a `Task`, without affecting 
the contents of other `Task` in the `TaskList`.
{Introduce how the addition command works}

The figure below shows how the delete task command works:
<img src=https://user-images.githubusercontent.com/60319628/96802352-426d8880-143c-11eb-9a7d-6e2d9a28df45.png>

1. The `CliUserInterface` receives the "delete 1" input by the user and passes it to the `InputParser` class.
2. `InputParser` parses the input to determine the type of command and the index of the task that is required to delete. 
The Parser then constructs a `RemoveCommandTimetableMode` with constructor as shown below.
```
public RemoveCommandTimetableMode(int indexToRemove, AppState uiMode) {
    this.setAppState(uiMode);
    this.indexToRemove = indexToRemove;
}
```
3. Method **execute()** then calls the `TaskList` stored in `AppState` to update the deletion of the task.
It also constructs `CliMessages` to display messages to the user.
4. If the deletion is successful, `CliMessages` is then called to display messages to the user.

##### 4.2.1.2. Design Considerations

###### Aspect: How to store tasks in `TaskList`
- **Alternative 1 (current choice):** Stores as an `ArrayList` of tasks
    - Pros: It is easier to implement because the code base are list based.
    - Cons: It is unoptimized in terms of complexity, which requires more work for scaling of the application.
- **Alternative 2:** Stores as a Hash Table with the key as the index and value as `Task`
    - Pros: It has a better time complexity and reduce the work in scaling stage since this data structure is more optimized (O(1) can be achieved).
    - Cons: It takes more resources to implement. Furthermore, 

### 4.2.2. List feature

#### 4.2.2.1. Implementation

The following sequence diagram shows how the list operation works:

<img src="https://github.com/longngng/tp/blob/longngng-DG/docs/diagrams/class/jpeg/SequenceDiagram_List.jpg">

#### 4.2.2.2. Design Considerations

### 4.3. Notebook Mode

## 5. Documentation
We use Markdown for writing our documents.

### 5.1. Setting up and maintaining the project website.
- We use **Jekyll** to manage documentation.
- The `docs/` folder is used for documentation.
- To learn how to set it up and maintain the project website, follow the guide
[[se-edu/guides] Using Jekyll for project documentation](https://se-education.org/guides/tutorials/jekyll.html).

### 5.2. Style guidance
- Follow the [Google developer documentation style guide](https://developers.google.com/style).
- Also relevant is the [[se-edu/guides] Markdown coding standard](https://se-education.org/guides/conventions/markdown.html).

### 5.3. Diagrams
We use Microsoft Visio Professional 2019 to draw our UML diagrams. 

### 5.4. Converting a document to the PDF Format

We use **Chrome** for converting documentation to PDF format.
> Reason: Chrome's PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
2. Within Chrome, click on the `Print` option in Chrome’s menu.
3. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format.
For best results, use the settings indicated in the screenshot below.
<img src=https://se-education.org/guides/tutorials/images/chrome_save_as_pdf.png>

## 6. Testing

### 6.1. Running tests

There are two ways to run tests.
- **Method 1: Using IntelliJ JUnit test runner**
    - To run all tests, right-click on the `src/test/java` and choose `Run 'Tests in tp.test'`
    - To run a subset of tests, you can right-click on a test package, test class, or a test and choose `Run 'ABC'`.
- **Method 2: Using Gradle**
    - Open a console and run the command `gradlew clean test` (Mac/Linux: `./gradlew clean test`)

### 6.2. Types of tests
{Describe the type of testing used in the code}

## Appendix A: Project Scope

**Target user profile**
- student with multiple courses
- has a need to multiple notes
- has a need to view upcoming tasks swiftly
- prefer desktop apps over other forms
- is reasonably comfortable using CLI apps

**Value proposition**:<br>
manage both tasks and notes faster and lighter than a typical mouse/GUI driven app

## Appendix B: User Stories

Priorities: High (must have) - `***`, Medium (nice to have) - `**`, Low (unlikely to have) - `*`

|Priority| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|`***`|user|record and save my notes|review them later|
|`***`|student|view all tasks and sections of my notebook|have a clear view of my progress|
|`***`|new user|have usage instructions|refer to instructions when I forget how to use the App|
|`**`|forgetful user|see the most urgent tasks|prioritise my tasks|
|`*`|long-time user|have personalised messages|feel attached to my notes|

## Appendix C: Use Cases

## Appendix D: Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

## Appendix E: Glossary

* **Mainstream OS**: Windows, Linux, OS-X
* **Notebook shelf**: a list of all notebooks entered by the user

## Appendix F: Instructions for manual testing

Given below are instructions to test the app manually.
>**Note**: These instructions only provide a starting point for testers to work on; 
>testers are expected to do more *exploratory* testing.

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
