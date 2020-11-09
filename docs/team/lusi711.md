# Lusi Wu Qi - Project Portfolio Page

## Overview
This project portfolio page aims to record my contributions to the Zer0Note project.

**Zer0Note** is a note taking and organisation application meant for students(especially those who can type fast).
We aim to help our target users integrate and speed up the note-taking and scheduling processes.

**Zer0Note** consists of two modes: Timetable and Notebook. The Timetable mode manages the tasks input by the user while
the Notebook mode manages the user's notes.

## Summary of Contribution

This section describes the contributions I made over the project term.

### Code contributed

All my work can be viewed [here](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=lusi711&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other).

### Enhancements implemented

- **Major enhancement**: Implemented a **Find** feature for both the Timetable and Notebook modes.
    - What it does: This feature allows the user to find tasks, and notebooks, sections and pages, from the respective
    modes in two ways. The user can search for all titles that contain a keyword, or search for all that have a specified 
    tag (Refer below).
    - Justification: This feature improves the product significantly as:
        - The feature efficiently saves time in terms of searching tasks and notes manually.
        - The feature allows the user to revise previous tasks and notes.
    - Highlights: This enhancement handles finding by keyword and tag within a single class `FindCommand`.
- **Minor enhancement**: Implemented a **Tag** feature for both the Timetable and Notebook modes.
    - What it does: This feature allows the user to add a tag to tasks, and notebooks, sections and pages, in the
    Timetable and Notebook mode respectively.
    -Justification: This feature is important because it allows the user to group multiple tasks, notebooks, sections 
    and pages into a single category without having the same 
    keyword in the title.
- **Minor enhancement**: Implemented a **Delete** feature for both the Timetable and Notebook modes.
    - What it does: This feature allows the user to remove an existing task in Timetable mode, and an existing notebook, 
    section or page, in the Notebook mode.
    - Justification: We thought this is a crucial feature for users to change wrongly written tasks and notes, or
     remove unwanted contents.

### Other contributions

Here are the other contributions I made to the project team:
- Documentation:
    - Wrote up the overall outline and structure for the Developer Guide: [#71](https://github.com/AY2021S1-CS2113T-T12-3/tp/pull/71).
    - Updated relevant sections of the User Guide and Developer Guide on individual features
- Update issue tracker: [#65](https://github.com/AY2021S1-CS2113T-T12-3/tp/issues/65), [#181](https://github.com/AY2021S1-CS2113T-T12-3/tp/issues/181)
- Reviewed teammates' pull requests on GitHub: [#44](https://github.com/AY2021S1-CS2113T-T12-3/tp/pull/44),
[#77](https://github.com/AY2021S1-CS2113T-T12-3/tp/pull/77), [#129](https://github.com/AY2021S1-CS2113T-T12-3/tp/pull/129)
- Reported bugs and suggestions for other teams in the class. See [here](https://github.com/Lusi711/ped)

## Contributions to the User Guide

```
Given below are sections I contributed to the User Guide. They showcase my ability to write documentation targeting 
end-users.
```
### Tagging tasks: `tag`

You have added a few tasks, and completed some of them. Congratulations! After reviewing, you realise that some of the
tasks come from the same module, or that some are non-academic-related. Is there any way you can categorise them together?

This command lets you add a single `tag` to an existing `task` to remind you of the category it belongs to. You can
learn how to search for all tasks with the same `tag` in [Finding tasks by tag](#3452-finding-by-tag).

>:bulb: Each task can only have one tag. The previous tag will be automatically overwritten by the new tag and no
>reminder will be given.

Format: `tag [INDEX] /t[TAG]`

These are the parameters required in the command:

* `INDEX`: index number of the intended task in the full task list
* `TAG`: text description of the tag



Example of usage:
For example, if you want to tag the first task in the list as "Todo", after `T:$` in the command window, type "tag 1 /tTodo".
Below shows the expected output:

```
T:$ tag 1 /tTodo
-------------------------------------------------------------
Got it! I've tagged this as:
 [o] Read book (by: Oct 19 2020 06.00PM)(tag: Todo)
-------------------------------------------------------------
```
### Finding tasks `find`

Your tasklist has grown, and it becomes a pain to go through every single task in the list. Filtering the list by
completion and deadline does not provide the intended result either. Don't worry! You can search for any task directly
too.

There are two ways to find a task:

#### Finding by keyword

Finds any task that contains the keyword in the task description.  The search is not case-sensitive.

Format: `find [KEYWORD]`

These are the parameters required in the command:

* `KEYWORD`: keyword to look for

Example of usage:

```
T:$ find book
-------------------------------------------------------------
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
2:[x] Return book (by: Oct 23 2020 12.00 PM)
-------------------------------------------------------------
```

#### Finding by tag

Finds any task that has a specified tag.  The search is not case-sensitive.

Format: `find /t[TAG]`

These are the parameters required in the command:

* `TAG`: tag to look for

Example of usage:

```
T:$ find /tTodo
-------------------------------------------------------------
Here are the tasks I found:
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
-------------------------------------------------------------
```

### Deleting a task: `delete`

Use the `delete` command to delete tasks you previously added to **Zer0Note**.

Format: `delete [INDEX]`

This is the parameter required in the command:

* `INDEX`: index number of the intended task in the full task list



Example of usage:

```
T:$ delete 1
-------------------------------------------------------------
Noted. I've removed this task:
[x] Read book (by: Oct 19 2020 06.00 PM)
	Now you have 4 tasks in the list.
-------------------------------------------------------------
```

### Tagging a notebook/section/page: `tag`

You have now several notebooks in the bookshelf. Some come from the same module, while others are just a running list of
inspirations you have.

This command lets you add a single `tag` to a selected `notebook`, `section` or `tag` to remind you of the category it
belongs to. You can learn how to search for all notebooks, sections and pages in the bookshelf with the same `tag` in
[Finding by tag](#3552-finding-by-tag).

>:exclamation: The tag is added to the selected notebook, section or page. The tag will not be added to components
> belonging to the selected notebook or section.
>
>:warning: Each notebook, section and page can only have one tag. The previous tag will be automatically overwritten
>by the new tag and no reminder will be given.

Format: `tag /t[TAG]`

These are the parameters required in the command:

* `TAG`: text description of the tag



Example of usage:
For example, you would to add a tag "Module" to a notebook titled "CS2101":

>:bulb: Remember to select the notebook "CS2101"!

```
N/CS2101:$ tag /tModule
-------------------------------------------------------------
Got it! I've tagged this as:
CS2101 (tag: Module)
-------------------------------------------------------------
```

### Finding contents: `find`

Just like how you can find a task in the Timetable mode, you can look for contents in this mode. Even sections and pages
that do not belong to a selected notebook can be found. There are two ways to do so:

#### Finding by keyword

Finds all notebooks, sections and pages that contain the keyword in their title.  The search is not case-sensitive.

Format: `find [KEYWORD]`

These are the parameters required in the command:

* `KEYWORD`: keyword to look for

Example of usage:

```
N:$ find chapter
-------------------------------------------------------------
I've found these for keyword: chapter
Sections:
1. CS2113T |-- Chapter 1

2. CS2113T |-- Chapter 2

3. CS2101 |-- Chapter 1

4. CS2101 |-- Chapter 2

5. CS2101 |-- Chapter 3

-------------------------------------------------------------
```
>:bulb: `|--` indicates "belongs to". You can use this to identify the particular notebook and section a page is in.

#### Finding by tag

Finds all notebooks, sections and pages that has a specified tag.  The search is case-sensitive.

Format: `find /t[TAG]`

These are the parameters required in the command:

* `TAG`: tag to look for

Example of usage:
```
N:$ find /tmodule
-------------------------------------------------------------
I've found these for tag: module
Notebooks:
1. CS2101

-------------------------------------------------------------
```

### Deleting a notebook/section/page: `delete`

Use the `delete` command to delete an existing notebook, section or page.

> :exclamation: The current selection determines the type you can delete.

Format: `delete /n[NOTEBOOK] /s[SECTION] /p[PAGE]`

* `NOTEBOOK`: the title of the notebook to be deleted
* `SECTION`: the title of the section to be deleted in the selected `NOTEBOOK`
* `PAGE`: the title of the page to be deleted in the selected `SECTION`.

In *NOTEBOOK MODE*,
* `delete /nCS2101 /sChapter 1 /pWriting email` deletes page `Writing email` under the section `Chapter 1` of the 
notebook `CS2101`.
* `delete /nCS2101 /sChapter 1` deletes the entire section titled `Chapter 1` in the notebook `CS2101`.
* `delete /nCS2101` deletes the entire notebook titled `CS2101`.

Example of usage:
```
N:$ delete /nCS2101 /sChapter 1 /pWriting email
-------------------------------------------------------------
Noted. I've removed this page: Writing email
Lorem ipsum
-------------------------------------------------------------
N:$ delete /nCS2101 /sChapter 1
-------------------------------------------------------------
Noted. I've removed this section: 
	Chapter 1
-------------------------------------------------------------
```

In a selected *NOTEBOOK*,
* `delete /sW1: Java /pHELLO WORLD` deletes page `HELLO WORLD` of the section titled `W1: Java` of the selected notebook.
* `delete /sW1: Java` deletes the section titled `W1: Java` of the selected notebook.

Example of usage:

In the notebook `CS2113T`:
```
N/CS2113T:$ delete /sW1: Java /pHELLO WORLD
-------------------------------------------------------------
Noted. I've removed this page: HELLO WORLD
System.out.println("Hello World!");
-------------------------------------------------------------
N/CS2113T:$ delete /sW1: Java
-------------------------------------------------------------
Noted. I've removed this section: 
	W1: Java
-------------------------------------------------------------
```
In a selected *SECTION*,
* `delete /p1` deletes page `1` of the selected section.

Example of usage:

In the section `Chapter 1` of notebook `CS2113T`:
```
N/CS2113T/Chapter 1:$ delete /pDefinition
-------------------------------------------------------------
Noted. I've removed this page: Definition
What is OOP?
-------------------------------------------------------------
```

## Contributions to the Developer Guide

```
These are the sections of the Developer Guide related to my task. They showcase my ability to clearly explain the 
technical documentation of my contributions to any new developers.
```

### Timetable Mode

#### TaskList Management Feature

**Implementation**

TaskList also allows the deletion of tasks by the user.

The figure below shows how the delete task command works:
![Sequence Diagram for Delete Task Command](diagrams/class/jpeg/delete_task.jpg)
Figure [9]. Sequence diagram for the Delete Task Command

Here are the general steps that the command goes through when the user inputs "delete 1":
1. The `CliUserInterface` receives the "delete 1" input by the user and passes it to the `InputParser` class.
2. `InputParser` parses the input to determine the type of command and the index of the task that is required to delete.
3. `InputParser` constructs a `RemoveCommandTimetableMode` and passes the index number to the class.
4. `RemoveCommandTimetableMode#execute()` is called to delete the task.
5. If the task is deleted, `RemoveCommandTimetableMode#execute()` also calls `CliMessages#printRemoveTaskMessage` to
display the success message to the user.
6. `CliUserInterface#IsTriggerAutosave` is called to verify whether a change has been made in the TaskList or
NotebookShelf.

**Design Considerations**

*Aspect: How to store tasks in `TaskList`*
- **Alternative 1 (current choice):** Store as an `ArrayList` of tasks
    - Pros: It is easier to implement because the code base are list based.
    - Cons: It is unoptimized in terms of complexity, which requires more work for scaling of the application.
- **Alternative 2:** Store as a Hash Table with the key as the index and value as `Task`
    - Pros: It has a better time complexity and reduce the work in scaling stage since this data structure is more optimized (O(1) can be achieved).
    - Cons: It takes more resources to implement. The constant factor for a hashing algorithm is significant and not
     worth the tradeoff for smaller amounts of data, like a typical user would be likely to generate.

#### Tag Feature
The user can tag `Task`s in the `TaskList`. This section describes the implementation and design considerations for this
feature.

**Implementation**
The `Task` class contains a member `tag` of String type.

The figure below shows how the tag operation works:

![Sequence Diagram for Tag Timetable command](diagrams/class/jpeg/tag_task.jpg)
Figure [11]. Sequence diagram for Tag Timetable Command

There are the general steps during the tag operation. When the user enters `tag 1 /tCS2113T` into the command window
while using the application:
1. The `CliUserInterface` receives the "tag 1 /tCS2113T" input by the user and passes it to the `InputParser` class.
2. `InputParser#getCommandFromInput` parses the input to get the task index number and the tag description
3. `InputParser#getCommandFromInput` then constructs the `TagCommandTimetableMode` class and returns it to
`CliUserInterface`.
4. `TagCommandTimetableMode#execute()` is called to tag the task.
5. If the tag is added successfully, `TagCommandTimetableMode#execute()` calls `CliMessages#printTagTaskMessage` to
display the success message to the user.
6. `CliUserInterface#IsTriggerAutosave` is called to verify whether a change has been made in the TaskList or
NotebookShelf.

**Design Considerations**
This section describes some of the considerations involved when designing the tag feature.

*Aspect: How to store the tags*
- **Alternative 1 (current choice):** Store as a private `String` member in every task
    - Pros: It is easy to access for print operations.
    - Cons: It is unoptimized in terms of complexity for search operations, which requires more work for scaling of the
    application.
- **Alternative 2:** Store as a Hash Table with the key as the tag and value as `Task`
    - Pros: It has a better time complexity for search operations since this data structure is more optimized (O(1) can
    be achieved).
    - Cons: It is hard to retrieve the tag for a specific `Task` due to the structure of the key-value pair.

#### Search Feature
This feature allows the user to search for tasks by keyword or by tag. Refer to [Tag Feature](#423-tag-feature) for more
 information on the implementation of tags.

This section explains the implementation and design considerations for the search feature.

**Implementation**

The class `FindCommandTimetableMode` executes the search feature. The following sequence diagram shows an example of
how the complete command works:

![Sequence Diagram for Find command](diagrams/class/jpeg/find_task.jpg)
Figure [13]. Sequence diagram for Find Command in Timetable Mode

For example, when the user enters `find /tCS2113T` into the command window while using the application:
1. The `CliUserInterface` receives the "find /tCS2113T" input by the user and passes it to the `InputParser` class.
2. `InputParser#getCommandFromInput` parses the input to return an empty keyword and the tag description.
3. `InputParser#getCommandFromInput` then constructs the `FindCommandTimetableMode` class and returns it to
`CliUserInterface`.
4. `FindCommandTimetableMode#execute()` is called to conduct the search.
    a. If tag is empty, `execute()` calls `getTasksWithTitleContainingKeyword(tasks)`, which returns all tasks which
    contain the keyword in their title.
    b. If keyword is empty, `execute()` calls `getTasksWithTag(tasks)`, which returns all tasks with the tag.
5. If the tag is added successfully, `TagCommandTimetableMode#execute()` displays all found tasks to the user.
6. `CliUserInterface#IsTriggerAutosave` is called to verify whether a change has been made in the TaskList or
NotebookShelf.

**Design Considerations**

This section describes some considerations involved when designing the find feature.

*Aspect: Distinction between finding by keyword and finding by tag*
- **Alternative 1 (current choice):** Handle as a if-else statement in a single class
- **Alternative 2:** Two different classes that are subclasses to a class `FindCommandTimetableMode`
    - Pros: Higher level of abstraction
    - Cons: Unable to be returned directly by `InputParser#getCommandFromInput` as they are not subclasses of the
    `CliCommand` class. An if-else statement is still required inside the`FindCommandTimetableMode#execute` method.

###  Notebook Mode

#### Notebook Management Feature

Notebook Mode also allows the user to remove a notebook/section/page.

The figure below shows how the "delete notebook" command works:
![Sequence Diagram for Delete Notebook Command](diagrams/class/jpeg/delete_notebook.jpg)
Figure [15]. Sequence diagram for Delete Command in Notebook Mode

The sequence diagram above depicts an example where the user wants to delete a page:
1. The `CliUserInterface` receives the "delete /nCS2113T /sTP /p11" input by the user and passes it to the `InputParser`
class.
2. `InputParser#getCommandFromInput` parses the input to return the notebook title "CS2113T", section title "TP", and the page title "11".
3. `InputParser#getCommandFromInput` then constructs the `RemoveCommandNotebookMode` class and returns it to
 `CliUserInterface`.
4. `RemoveCommandNotebookMode#execute()` is called to delete the page.
    a. If the user is in a bookshelf, `execute()` calls `removeFromNotebookshelf()`.
    b. If the user is in a notebook, `execute()` calls `removeFromNotebook(Notebook)`.
    c. If the user is in a section, `execute()` calls `removeFromSection(Section)`.
5. `CliUserInterface#IsTriggerAutosave` is called to verify whether a change has been made in the NotebookShelf.

#### Tag Feature

The user can add a `tag` to a `Notebook`, `Section` or `Page`. This section describes the implementation and design
considerations for this feature.

**Implementation**
The `Notebook`, `Section` and `Page` classes each contain a member `tag` of type String.

The figure below shows how the tag operation works:

![Sequence Diagram for Tag Notebook command](diagrams/class/jpeg/tag_notebook.jpg)
Figure [17]. Sequence diagram for Tag Command in Notebook Mode

When the user enters `tag /tCS2113T` into the command window while using the application:
1. The `CliUserInterface` receives the "tag /tCS2113T" input by the user and passes it to the `InputParser`
class.
2. `CliUserInterface#executeCommand(String argument)` calls `InputParser#getCommandFromInput`.
2. `InputParser#getCommandFromInput` first parses the input to return the tag "CS2113T".
3. `InputParser#getCommandFromInput` then constructs the `TagCommandNotebookMode` class and returns it to
 `CliUserInterface`.
4. `TagCommandNotebookMode#execute()` is called to add a tag to the notebook/section/page the user is in.
5. `CliUserInterface#IsTriggerAutosave` is called to verify whether a change has been made in the NotebookShelf.

**Design Considerations**
This section describes some of the considerations involved when designing the tag feature.

*Aspect: How to store the tags*
- **Alternative 1 (current choice):** Store as a private `String` member in every task
    - Pros: It is easy to access for print operations.
    - Cons: It is unoptimized in terms of complexity for search operations, which requires more work for scaling of the
    application.
- **Alternative 2:** Store as a Hash Table with the key as the tag and value as `Task`
    - Pros: It has a better time complexity for search operations since this data structure is more optimized (O(1) can
    be achieved).
    - Cons: It is hard to retrieve the tag for a specific `Task` due to the structure of the key-value pair.

#### Search Feature

This feature works similarly to the [search feature](#425-search-feature) in the Timetable mode. Refer to
[Tag Feature](#433-tag-feature) for more information on the implementation of tags in the Notebook mode.

**Implementation**

The following sequence diagram shows how the search feature works in the notebook mode:

![Sequence Diagram for Find Notebook Command](diagrams/class/jpeg/find_notebook.jpg)
Figure [18]. Sequence diagram for Find Command in Notebook Mode

As the implementation of the search feature in the Notebook mode is similar to that in the Timetable mode, except:
- The `CliMessages` class is constructed in `FindCommandNotebookMode#execute()` to display all the notebooks, sections
and pages found.

**Design Considerations**

*Aspect: Way to search through the notebook shelf*
- **Alternative 1 (current choice):** Loop through every page, section and notebook
    - Pros: Able to trace the notebook and section that a found page belongs to. This makes it more convenient to show
    to the user.
    - Cons: It is unoptimized in terms of complexity, with a complexity of O(n<sup>3</sup>).
- **Alternative 2:** Store all notebooks, sections and pages into respective lists
    - Pros: Has better time complexity of O(n) as it only needs to iterate through each list.
    - Cons: Unable to output the notebook and section that a page belongs to the user.
