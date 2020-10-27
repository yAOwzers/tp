# Developer Guide for Zer0Note

[1. Introduction](#1-introduction) <br>
&nbsp;&nbsp;[1.1. Welcome!](#11-welcome)<br>
&nbsp;&nbsp;[1.2. How to use this document](#12-how-to-use-this-document)<br>
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
&nbsp;&nbsp;&nbsp;&nbsp;[4.1.1. Implementation](#411-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.1.2. Design Considerations](#412-design-considerations) <br>
&nbsp;&nbsp;[4.2. Timetable Mode](#42-timetable-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1. Tasklist Management Feature](#421-tasklist-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2. List Feature](#421-tasklist-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;[4.3. Notebook Mode](#43-notebook-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.1. Notebook Management Feature](#431-notebook-management-feature) <br>
&nbsp;&nbsp;[4.4. [Proposed] Find duplicates](#44-find-duplicates) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1 Proposed implementation](#441-proposed-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.2 Design considerations](#442-design-considerations) <br>
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

### 1.1. Welcome!
Welcome, and thank you for choosing to help contribute to Zer0Note! Zer0Note is a command-line based note-taking and
organisation application. It is designed to combine the features of graphical tools like OneNote and Notion, with
the editing speed of applications like vim and emacs. 
  
This document is written for developers intending to improve Zer0Note, by fixing bugs, or perhaps adding entirely new
features. It explains how the project is set up, the architecture used, and the code style you should adopt when
contributing code to the project. 
    
### 1.2. How to use this document

Text that looks like this is normal text. It should be read as-is; it has no special meaning beyond what it says. 

Example: The sequence diagram below shows the operation of the delete command. 

<br>

`Text that looks like this denotes a keyword or small extract of code.`

Example: The `CliUserInterface` is used to handle input and output to and from the console. 

<br>

```
    Text that looks like this denotes a larger extract of code. 
```

Example:
```java
    System.out.println("This is a code block!");
```

<br>

**`Text that looks like this denotes a button, or other UI element you may see on screen. `**

Example: Click **`Configure` ** > **`Project Defaults`** > **`Project Structure`**

<br> 

> Text that looks like this indicates a tip, providing additional information that is useful but not critically
> important

Example: 

> We use this method because Chrome's built-in PDF viewer preserves hyperlinks. 

<br>

> :exclamation: Text that looks like this, beginning with the :exclamation: sign indicates information that is very
> important, such as warnings about potential mistakes or common problems

Example:

> :exclamation: **Caution** Follow the steps in the following guide precisely. 

## 2. Setting up

The following section describes how to set up the coding environment on your own computer, in order to start writing
code to improve Zer0Note. 

### 2.1. Prerequisites

1. **JDK** 11
2. **IntelliJ** IDEA

### 2.2. Setting up the project in your computer

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

The following section describes the design and implementation of the product. UML diagrams and code snippets are used
to explain some aspects of the code. If you are unfamiliar with UML, the diagrams should still be fairly
understandable. However, you may wish to consult [[CS2113/T] Modeling](https://nus-cs2113-ay2021s1.github.io/website/se-book-adapted/chapters/modeling.html) for a quick introduction to UML. 

### 3.1 Architecture

**How the architecture components interact with each other**
The Sequence Diagram below shows how the components interact with each other for the scenario...

/* work in progress */

### 3.2 UserInterface Component

The UserInterface Component is made up of `AppMode`, `AppState`, `CliMessages`, `CliUserInterface`, `InputParser`.

The `UserInterface` component,

* Executes user commands using the `Commands` component.
* // how it interacts with the other components

/* TODO explain the various variables and methods */

### 3.3. Commands Component

![UML diagram for Timetable Commands](/diagrams/class/jpeg/timetable_commands.jpg)

![UML diagrams for Notebook Commands](/diagrams/class/jpeg/notebook_commands.jpg)

/* to insert UML diagram */

The `Commands` component, 

// TODO add components

### 3.4. Tasks Component

/* to insert UML diagram */

### 3.5 Notebooks Component

![UML diagram for Notebooks](/diagrams/class/jpeg/notebooks.jpg)

/* TODO explain the various variables and methods */

### 3.6. Storage Component

/* to insert UML diagram */

## 4. Implementation

The following section describes the implementation of certain key features in the current version of Zer0Note. It also
provides some background into our (the original developers of Zer0Note) thinking and the rationale behind the
decisions. 

### 4.1. Mode Switch Feature

#### 4.1.1. Implementation

/* work in progress */

#### 4.1.2. Design Considerations

/* work in progress */

### 4.2. Timetable Mode

#### 4.2.1. Tasklist Management Feature

##### 4.2.1.1. Implementation

`TaskList` is implemented to manage and store the tasks input by the user. It comprises of an `ArrayList` list of
 `Task`s, and a few helper methods. 

This means that multiple operations such as addition and deletion can be done on a `Task`, without affecting
the contents of other `Task` in the `TaskList`.
{Introduce how the addition command works}

The figure below shows how the delete task command works:
<img src= "https://user-images.githubusercontent.com/60319628/96657942-02dc6900-1376-11eb-9284-38322e1a2b09.png">

1. The `CliUserInterface` receives the "delete 1" input by the user and passes it to the `InputParser` class.
2. `InputParser` parses the input to determine the type of command and the index of the task that is required to delete.
The Parser then constructs a `RemoveCommandTimetableMode` with constructor as shown below.
```java
public RemoveCommandTimetableMode(int indexToRemove, AppState uiMode) {
    this.setAppState(uiMode);
    this.indexToRemove = indexToRemove;
}
```
3. Method **execute()** then calls the `TaskList` stored in `AppState` to update the deletion of the task.
It also constructs `CliMessages` to display messages to the user.
4. If the deletion is successful, `CliMessages` displays the message to the user.

##### 4.2.1.2. Design Considerations

###### Aspect: How to store tasks in `TaskList`
- **Alternative 1 (current choice):** Store as an `ArrayList` of tasks
    - Pros: It is easier to implement because the code base are list based.
    - Cons: It is unoptimized in terms of complexity, which requires more work for scaling of the application.
- **Alternative 2:** Store as a Hash Table with the key as the index and value as `Task`
    - Pros: It has a better time complexity and reduce the work in scaling stage since this data structure is more optimized (O(1) can be achieved).
    - Cons: It takes more resources to implement. The constant factor for a hashing algorithm is significant and not
     worth the tradeoff for smaller amounts of data, like a typical user would be likely to generate. 

### 4.2.2. List feature

#### 4.2.2.1. Implementation

The following sequence diagram shows how the list operation works:

![Sequence Diagram for List command](/diagrams/class/jpeg/SequenceDiagram_List.jpg)


### 4.3. Notebook Mode

#### 4.3.1. Notebook Management Feature

As shown in Figure 1, the `NotebookShelf` class comprises instances of `Notebook` class. `Notebook` comprises `Section`
and `Section` comprises `Page`. The navigability is not bidirectional. Multiple operations such as addition and deletion
can be done without affecting other instances at all, while updating the `Notebook` it is in.

The figure below shows how the delete task command works:
<img src="https://user-images.githubusercontent.com/60319628/96821973-9176e600-145b-11eb-95b7-5bf885ea1867.png">

After calling `InputParser#getCommandFromInput` from `CliUserInterface`:
1. `InputParser` parses the input to return the `notebookTitleToRemove`, `sectionTitleToRemove` and `pageNumberToRemove`.
Some of these members may be empty.
2. `InputParser` constructs and returns the `RemoveCommandNotebookMode` class with constructor as shown below:
```java
public RemoveCommandNotebookMode(String notebookTitle, String sectionTitle,
                                     int pageNumber, AppState appState) {
    this.appState = appState;
    notebookTitleToRemove = notebookTitle;
    sectionTitleToRemove = sectionTitle;
    pageNumberToRemove = pageNumber;

    currentBookshelf = appState.getCurrentBookShelf();
    currentNotebook = appState.getCurrentNotebook();
    currentSection = appState.getCurrentSection();
}
```
3. Method **execute()** is called by `CliUserInterface` to delete a notebook, section, or page, depending on the input.
A switch-case block is used to determine the method to call based on the `appMode`.
4. If the deletion is successful, `CliMessages` displays the message to the user.


### 4.4 [Proposed] Find duplicate feature

#### 4.4.1 Proposed implementation

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

#### 4.4.2 Design consideration

##### Aspect: Where findDuplicate should be placed

* **Alternative 1 (current choice)**: findDuplicate should be saved in the class that potentially creates duplicates.
  * Pros: Easier to access previously saved tasks/notebooks/notebook sections.
  * Cons: May have performance issues in terms of memory usage.
* **Alternative 2**: findDuplicate should be saved in the command that creates it.
  * Pros: Less time spent in passing variables to different classes.
  * Cons: We must grant access to private objects that are not within the command class.

## 5. Documentation

The following section describes how documentation for the project should be written. Note: documentation is all
 written in [GitHub-Flavoured Markdown](https://github.github.com/gfm/). 

### 5.1. Setting up and maintaining the project website.
- We use **Jekyll** to manage documentation.
- The `docs/` folder is used for documentation.
- To learn how to set it up and maintain the project website, follow the guide
[[se-edu/guides] Using Jekyll for project documentation](https://se-education.org/guides/tutorials/jekyll.html).

### 5.2. Style guidance
- Follow the [Google developer documentation style guide](https://developers.google.com/style).
- Also relevant is the [[se-edu/guides] Markdown coding standard](https://se-education.org/guides/conventions/markdown.html).

### 5.3. Diagrams

We use Microsoft Visio Professional 2019 to draw our UML diagrams. If you do not have access to this software, free
alternatives such as [Lucidchart](https://www.lucidchart.com/pages/), [Google Drawings](https://docs.google.com/drawings),
[LibreOffice Draw](https://www.libreoffice.org/discover/draw/) and many others are also available. If you wish to 
contribute diagrams (which we recommend you do if you contribute new features!), you may use any software of your
choosing to draw the diagrams, as long as the finished product somewhat resembles those we already have and follows
UML syntax strictly. 

### 5.4. Converting a document to the PDF Format

We use **Chrome** for converting documentation to PDF format.
> Reason: Chrome's PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
2. Within Chrome, click on the `Print` option in Chrome’s menu.
3. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format.
For best results, use the settings indicated in the screenshot below.

<img src= "https://se-education.org/guides/tutorials/images/chrome_save_as_pdf.png">

## 6. Testing

The following section describes the testing methodologies followed in this project to ensure high-quality, bug-free
code as far as possible. 

### 6.1. Running tests

There are two ways to run tests.
- **Method 1: Using IntelliJ JUnit test runner**
    - To run all tests, right-click on the `src/test/java` and choose `Run 'Tests in tp.test'`
    - To run a subset of tests, you can right-click on a test package, test class, or a test and choose `Run 'ABC'`.
- **Method 2: Using Gradle**
    - Open a console and run the command `gradlew clean test` (Mac/Linux: `./gradlew clean test`)

### 6.2. Types of tests
{Describe the type of testing used in the code}

This project has one type of test:
Unit tests targeting the lowest level methods/classes.
e.g. `seedu.duke.userinterface.command.notebook.AddNotebookTest`

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

(For all use cases below, the System is the `Zer0Note` and the Actor is the `user`, unless specified otherwise)

### Use case: Delete task

1. User requests to list tasks
2. Zer0Note shows a list of tasks
3. User requests to delete a specific task in the list 
4. Zer0Note deletes the task  
    Use case ends.

#### Extensions

* 2.1. The task list is empty.  
  Use case ends.  
* 3.1. The given index is invalid.  
   * 3.1.1 Zer0Note shows an error message.  
        Use case resumes at step 2.
        
/* work in progress */

## Appendix D: Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

## Appendix E: Glossary

* **Mainstream OS**: Windows, Linux, macOS
* **Notebook shelf**: a list of all notebooks entered by the user

## Appendix F: Instructions for manual testing

Given below are instructions to test the app manually.
>**Note**: These instructions only provide a starting point for testers to work on;
>testers are expected to do more *exploratory* testing.

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### 1. Launch and Shutdown
1. Initial launch  
i. Download the jar file and copy into an empty folder.
ii. Double-click the jar file  

### 2. Test Cases

#### 2.1 Deleting a task
1. Deleting a task while all tasks in the existing tasklist is listed.
i. Prerequisites: User must be in the Timetable mode. Enter `mode /t` command to enter Timetable mode. List all tasks in the tasklist using the `list` command. There must be existing tasks in the list.  
ii. Test case: `delete 1`    
Expected: First task should be deleted from the tasklist.  
iii. Test case: `delete 0`  
Expected: No task is deleted. Error message will be printed in the command line interface.  
iv. Other incorrect delete commands to try: `delete`, `delete x` (where x is larger than the number of tasks in the tasklist)  
Expected: Similar to previous.

#### 2.2 Adding a task

1. Adding a task to the tasklist.  
i. Prerequistes: User must be in the Timetable mode. Enter `mode /t` command to enter Timetable mode. 
ii. Test case: `add /t test task /by 10-10-2020 2000` 
Expected: Task is added into the tasklist with a success message printed.  
iii. Test case: `add /t test task`  
Expected: An error messsage will be printed in the command line interface.  
iv. Test case: `add`  
Expected: An error message along with a formatting guideline message will be printed.
v. Test case: `add /t test task /by 2020-10-10 2000`  
Expected: An error message along with a formatting guideline message will be printed in the command line interface.

#### 2.3 Marking a task as done

1. Marking a task as done while there are existing task in the tasklist.  
i. Prerequistes: User must be in the Timetable mode. Enter `mode /t` command to enter Timetable mode. List all tasks in the tasklist using the `list` command. There must be existing tasks in the list.  
ii. Test case: `done 1` 
Expected: First task should be marked as done in the tasklist.  
iii. Test case: `done 0`  
Expected: An error messsage will be printed in the command line interface.  
iv. Other incorrect done commands to try: `done`, `done x` (where x is larger than the number of tasks in the tasklist)  
Expected: Similar to previous.

#### 2.4 Tagging a Task

#### 2.5 Listing a Task

1. Listing existing task in the tasklist.  
i. Prerequistes: User must be in the Timetable mode. Enter `mode /t` command to enter Timetable mode. There must be existing tasks in the list.

1.1 Listing all existing task in the tasklist.  
i. Test case: `list` 
Expected: All existing tasks in the tasklist will be printed out. 

1.2 Listing all marked as done existing tasks in the tasklist.  
i. Test case: `list /d`  
Expected: All existing marked as done tasks in the tasklist will be printed out.  

1.3 Listing all undone existing tasks in the tasklist.  
i. Test case: `list /u`  
Expected: All existing undone tasks in the tasklist will be printed out.  

1.4 Listing all urgent existing tasks in the tasklist.  
i. Test case: `list /urgent`  
Expected: All existing urgent tasks in the tasklist will be printed out.  

#### 2.6 Executing a mode switch

1. Switching between Timetable mode and Notebook mode.  
i. Prerequistes: User must be in the Timetable mode. Enter `mode /t` command to enter Timetable mode.  
ii. Test case: `mode /n` 
Expected: Mode is switched to Notebook mode.  
iii. Test case: `mode /t`  
Expected: Mode is switched to Timetable mode.  
iv. Test case: `mode`  
Expected: An error message along with a formatting guideline message will be printed in the command line interface..  

#### 2.7 Finding a Task using a keyword

#### 2.8 Adding a Notebook/Section/Page

1. Adding a respective notebook/section/page in their respective list.  
i. Prerequistes: User must be in the Notebook mode. Enter `mode /n` command to enter Notebook mode.    

1.1 Adding a Notebook.  
i. Prerequistes: User must not be in a selected notebook or section. User should type `mode /n` before executing this test case.   
ii. Test case: `add /nCS2113T` 
Expected: Notebook 'CS2113T' is added to the notebookShelf with a success message printed.  

1.2 Adding a Section.  
i. Prerequistes: User must select a notebook. Enter `select /s[NOTEBOOK]` to enter a specified notebook.    
ii. Test case: `add /nChapter 1` 
Expected: Section 'Chapter 1' is added to the specified notebook with a success message printed.  

1.3 Adding a Page.  
i. Prerequistes: User must select a Section. Enter `select /s[SECTION]` to enter a specified section.    
ii. Test case: `add /p Page 1 ; a test page` 
Expected: Page 'Page 1' along with content 'a test page' is added to the specified section with a success message printed.  

#### 2.9 Selecting a Notebook/Section/Page

1. Selecting a respective notebook/section/page in their respective list.  
i. Prerequistes: User must be in the Notebook mode. Enter `mode /n` command to enter Notebook mode.  

1.1 Selecting a Notebook.  
i. Prerequistes: User must not be in a section. User should type `mode /n` before executing this test case.   
ii. Test case: `select /nCS2113T` 
Expected: The user will enter the selected notebook 'CS2113T' with a success message printed. 

1.2 Selecting a Section.  
i. Prerequistes: User must be in a selected notebook. Enter `select /s[NOTEBOOK]` to enter a specified notebook.   
ii. Test case: `select /sChapter 1` 
Expected: The user will enter the selected Section 'Chapter 1' with a success message printed. 

1.3 Selecting a Page.  
i. Prerequistes: User must be in a selected section. Enter `select /s[SECTION]` to enter a specified section.   
ii. Test case: `select /sPage 1` 
Expected: The user will enter the selected Page 'Page 1' with a success message printed. 

#### 2.10 Deleting a Notebook/Section/Page

1. Deleting a respective notebook/section/page in their respective list.
i. Prerequistes: User must be in the Notebook mode. Enter `mode /n` command to enter Notebook mode. There must be existing notebooks/sections/pages in the respective list when command `list` is entered.  

1.1 Deleting a notebook.
i. Test case: `delete /nCS2113T`    
Expected: The selected notebook 'CS2113T' will be deleted, along with the sections and pages under it, with a success message printed. 

1.2 Deleting a section.
i. Test case: `delete /sChapter 1`    
Expected: The selected section 'Chapter 1' will be deleted, along with the pages under it, with a success message printed. 

1.3 Deleting a notebook.
i. Test case: `delete /pPage 1`    
Expected: The selected page 'Page 1' will be deleted with a success message printed. 


#### 2.11 Listing a Notebook/Section/Page 

1. Listing existing notebook/section/page in the NotebookShelf.  
i. Prerequistes: User must be in the Notebook mode. Enter `mode /n` command to enter Notebook mode. There must be existing notebooks/sections/pages in the respective list when command `list` is entered.  
ii. Test case: `list`  
Expected: All existing Notebooks/Sections/Pages will be listed in the given NotebookShelf/Notebook/Section respectively.  

1.1 Listing all n task in the tasklist.  
i. Test case: `list /a` 
Expected: All notebooks, sections and pages will be printed out.  

#### 2.12 Tagging a Notebook/Section/Page

### 3. Saving Data 

1. Dealing with corrupted data files  
i. Click on the folder that the jar file had been saved in.  
ii. Select both the 'tasks.txt' and 'notebooks.txt'.
iii. Delete both files.
iv. Restart the application by double-clicking the jar file and running Zer0Note.


