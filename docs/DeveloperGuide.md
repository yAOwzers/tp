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
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2. Tag Feature](#422-tag-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2. List Feature](#421-tasklist-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.1. Implementation](#4211-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2.2. Design Considerations](#4212-design-considerations) <br>
&nbsp;&nbsp;[4.3. Notebook Mode](#43-notebook-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.1. Notebook Management Feature](#431-notebook-management-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.3.1.1. Implementation](#4311-implementation)
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.2. Tag Feature](#432-tag-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.3.2.1. Implementation](#4321-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.3.2.2. Design Considerations](#4322-design-considerations) <br>
&nbsp;&nbsp;[4.4. Notebook Mode](#44-storage-neil) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1. Storage Format](#441-storage-format) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1.1. TaskList](#4411-tasklist) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1.2. Page](#4412-page) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1.3. Section](#4413-section) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1.4. Notebook](#4414-notebook) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1.5. NotebookShelf](#4415-notebookshelf) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.2. Implementation](#442-implementation) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.2.1. Saving the application state](#4421-saving-the-application-state) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4.4.2.2. Reading the application state](#4422-reading-the-application-state) <br>
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

## 1. Introduction (Neil)

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

### 3.1 Architecture (Neil)

**How the architecture components interact with each other**
The Sequence Diagram below shows how the components interact with each other for the scenario...

/* work in progress */

### 3.2 UserInterface Component (Neil)

The UserInterface Component is made up of `AppMode`, `AppState`, `CliMessages`, `CliUserInterface`, `InputParser`.

The `UserInterface` component,

* Executes user commands using the `Commands` component.
* // how it interacts with the other components

/* TODO explain the various variables and methods */

### 3.3. Commands Component (Neil)

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

#### 4.2.2. Tag Feature
The user can tag `Task`s in the `TaskList`. This section describes the implementation and design considerations for this
feature.

##### 4.2.2.1. Implementation
The `Task` class contains a member `tag` of String type. 

The figure below shows how the tag operation works:

![Sequence Diagram for Tag Timetable command](/diagrams/class/jpeg/SequenceDiagram_TagTimetable.jpg)

There are 3 crucial processes during the tag operation. When the user enters `tag 1 /tCS2113T` into the command window while using the application:

**Input Parsing**
1. `CliUserInterface` receives the "tag 1 /tCS2113T" input by the user and calls the `executeCommand` method.
2. Method `executeCommand` constructs the `InputParser` class and calls `InputParser#getCommandFromInput` to pass the 
input to `InputParser`.
3. `InputParser#getCommandFromInput`calls `InputParser#parseTagDescription` to separate the index from the tag.
4. If the application is in the timetable mode, `InputParser#getCommandFromInput` then parses the index and constructs 
the `TagCommandTimetableMode` class.
5. `InputParser#getCommandFromInput` returns `TagCommandTimetableMode` back to `CliUserInterface`

**Command Execution**
1. `CliUserInterface#executeCommand` calls `TagCommandTimetableMode#execute` to execute the command.
2. In `TagCommandTimetableMode#execute()`, the `CliMessages` class, which prints any outputs to the user, is constructed. 
3. `Tasklist#getTask` returns the `Task` that is specified by the index.
4. `Task#setTag` changes the `tag` member of `Task` to the tag input by the user.
5. If the tag is successful, `CliMessages#printTagTaskMessage` displays the message to the user.

**Storage**
1. `CliUserInterface#executeCommand` finally calls `TagCommandTimetableMode#isTriggerAutoSave` method to check whether a change 
has been made. 
2. If the method returns `True`, `CliUserInterface#executeCommand`calls `saveState` method to save the 
current list.
3. The tag operation ends.

##### 4.2.2.2. Design Considerations
This section describes some of the considerations involved when designing the tag feature.

###### Aspect: How to store the tags
- **Alternative 1 (current choice):** Store as a private `String` member in every task
    - Pros: It is easy to access for print operations.
    - Cons: It is unoptimized in terms of complexity for search operations, which requires more work for scaling of the 
    application.
- **Alternative 2:** Store as a Hash Table with the key as the tag and value as `Task`
    - Pros: It has a better time complexity for search operations since this data structure is more optimized (O(1) can 
    be achieved).
    - Cons: It is hard to retrieve the tag for a specific `Task` due to the structure of the key-value pair.

#### 4.2.3. List Feature

##### 4.2.3.1. Implementation

The following sequence diagram shows how the list operation works:

![Sequence Diagram for List command](/diagrams/class/jpeg/SequenceDiagram_List.jpg)

### 4.3. Notebook Mode

#### 4.3.1. Notebook Management Feature

As shown in Figure 1, the `NotebookShelf` class comprises instances of `Notebook` class. `Notebook` comprises `Section`
and `Section` comprises `Page`. The navigability is not bidirectional. Multiple operations such as addition and deletion
can be done without affecting other instances at all, while updating the `Notebook` it is in.

This section explains the implementation and design considerations for managing `Notebook`s.

##### 4.3.1.1 Implementation
There are two main functions in notebook management: add and remove.
<!--TODO: Explain implementation of add notebook/section/page-->

The figure below shows how the "remove task" command works:
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

#### 4.3.2. Tag Feature

The user can add a `tag` to a `Notebook`, `Section` or `Page`. This section describes the implementation and design 
considerations for this feature.

##### 4.3.2.1. Implementation
The `Notebook`, `Section` and `Page` classes each contain a member `tag` of type String.

The figure below shows how the tag operation works:

![Sequence Diagram for Tag Notebook command](/diagrams/class/jpeg/SequenceDiagram_TagNotebook.jpg)

There are 3 crucial processes during the tag operation. When the user enters `tag /tCS2113T` into the command window while using the application:

**Input Parsing**
1. `CliUserInterface` receives the "tag /tCS2113T" input by the user and calls the `executeCommand` method.
2. Method `executeCommand` constructs the `InputParser` class and calls `InputParser#getCommandFromInput` to pass the 
input to `InputParser`.
3. `InputParser#getCommandFromInput`calls `InputParser#parseTagDescription` to separate the index from the tag.
4. If the application is in the notebook mode, `InputParser#getCommandFromInput` constructs the 
`TagCommandTimetableMode` class. Note that `AppState#getCurrentNotebook`, `AppState#getCurrentSection` and 
`AppState#getCurrentPage` are called to determine the state of the application.
5. `InputParser#getCommandFromInput` returns `TagCommandNotebookMode` back to `CliUserInterface`.

**Command Execution**
1. `CliUserInterface#executeCommand` calls `TagCommandNotebookMode#execute` to execute the command.
2. `TagCommandNotebookMode#execute()` first constructs the `CliMessages` class, which prints any outputs to the user. 
3. `AppState#getAppMode` returns where the user is.
3. If the user is in a `Notebook`, `Section` or `Page`, `Notebook#setTag`, `Section#setTag` or `Page#setTag` is called 
respectively to change the tag of the current notebook.
4. If the tag is successful, `CliMessages#printTagNotebookMessage` displays the message to the user.

**Storage**
1. `CliUserInterface#executeCommand` finally calls `TagCommandNotebookMode#isTriggerAutoSave` method to check whether a 
change has been made. 
2. If the method returns `True`, `CliUserInterface#executeCommand`calls `saveState` method to save the 
current list.
3. The tag operation ends.

##### 4.3.2.2. Design Considerations
This section describes some of the considerations involved when designing the tag feature.

###### Aspect: How to store the tags
- **Alternative 1 (current choice):** Store as a private `String` member in every task
    - Pros: It is easy to access for print operations.
    - Cons: It is unoptimized in terms of complexity for search operations, which requires more work for scaling of the 
    application.
- **Alternative 2:** Store as a Hash Table with the key as the tag and value as `Task`
    - Pros: It has a better time complexity for search operations since this data structure is more optimized (O(1) can 
    be achieved).
    - Cons: It is hard to retrieve the tag for a specific `Task` due to the structure of the key-value pair.

### 4.4. Storage (Neil)

The `Storage` class is used to read and write the application state to and from a text file. 

#### 4.4.1. Storage format

This section describes the format used to store the TaskList and NotebookShelf from the application state in a plain
text file. 

:exclamation: The operating system newline character is used to terminate lines; that is, `\r\n` on Windows and 
`\n` on UNIX-based systems. 

##### 4.4.1.1. TaskList

For `TaskList`, the format is as follows:

* One line containing an integer `n`, the number of tasks.
* `3n` lines follow, every 3 lines describing one task. 
* The first line contains the task title as a String.
* The second line contains the task due date, in the format `dd-MM-yyyy hhmm`.
* The third line contains a value `true` or `false`, indicating whether the task is done. (`true` means done, 
`false` means not done.) 

##### 4.4.1.2. Page

For a single page, the format is as follows: 

* One line containing the title of the page. 
* One line containing the content of the page. Newline characters in the content are replaced with the string `"~~~"`.

##### 4.4.1.3. Section

For a single section, the format is as follows:

* One line containing an integer `p`, the number of pages in the section. 
* `p` pages are then described, as specified [here](#4412-page). 

##### 4.4.1.4. Notebook

For a single notebook, the format is as follows: 

* One line containing an integer `s`, the number of sections. 
* `s` sections are then described, as specified [here](#4413-section)

##### 4.4.1.5. NotebookShelf

For `NotebookShelf`, the format is as follows:

* One line containing an integer `n`, the number of notebooks. 
* `n` notebooks are then described, as specified [here](#4414-notebook). 

#### 4.4.2 Implementation

`TaskList`, `Task`,`NotebookShelf`, `Notebook`, `Section`, and `page` contain methods called `serialize()`. 
These methods return`String` representations of themselves, as specified [here](#441-storage-format).  

The `serialize()` method in `TaskList` calls the `serialize()` methods for every `Task` object within 
it and combines their outputs with a `StringBuilder`. 

The `serialize()` method in `NotebookShelf` calls the `serialize()` methods for every `Notebook` object within it and
combines their outputs with a `StringBuilder`. 

The `serialize()` method in `Notebook` calls the `serialize()` methods for every `Section` object within 
it and combines their outputs with a `StringBuilder`. 

The `serialize()` method in `Section` calls the `serialize()` methods for every `Page` object within it and
combines their outputs with a `StringBuilder`. 

##### 4.4.2.1. Saving the application state

The following sequence diagram describes the operation of the `saveToFile()` operation

![Sequence Diagram for saveToFile command](diagrams/class/jpeg/storage_neil.jpg)

The `Storage.saveToFile()` method saves the current application state to a file. 

##### 4.4.2.2. Reading the application state

### 4.5 [Proposed] Find duplicate feature

#### 4.5.1 Proposed implementation

The proposed find duplicate function is facilitated by a method in the classes `Task List`, `Notebook Shelf`, `Notebook` 
and `Section`. 

<br>

Given below is an example usage scenario and how the find duplicates function behaves.

Step 1. The user launches the application for the first time. `CliUserInterface#executeCommand` is called when the user 
adds a task into the task list.

Step 2. The user types `add /tTask /by19-10-2020 1900`. The `add` command is passed through 
`InputParser#getCommandFromInput`, which then calls `AddCommandTimetableMode#execute()`.

Step 3. `execute()` is called, which then calls `InputParser#parseTaskTitle`, which first extracts the `title` from the 
user's input.

Step 4. The `title` is then passed to the `findDuplicate` method in `TaskList`.

Step 5. The `findDuplicate` method returns false, since it is the first task titled `Task` to be added into the 
`TaskList`. Conversely, the `findDuplicate` method returns true when a task with the same `title` already exists in the 
`TaskList`.

Step 6. `InputParser#parseDeadline` is then called, which returns the `deadline` to `AddCommandTimetableMode#execute()`.

Step 7. `TaskList#addTask` is then called and a new `Task`, with `title` and `deadline`, is initialised.

Step 8. To signal that the user has successfully added a task, a message is printed with 
`CliMessages#printAddedTaskMessage`.

The sequence diagram below shows how the find duplicate command works:

![Sequence diagram for finding duplicates](/diagrams/class/jpeg/duplicates_francene.jpg)

#### 4.5.2 Design consideration

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

1. Launch and Shutdown
2. {Test case eg. Deleting a task}
3. Saving Data (dealing with missing/corrupted data files)
