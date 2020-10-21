# User Guide

## Navigation Panel
- [Introduction](#introduction)
- [Quick Start](#quick-start)
- [Features](#features)
  - [Viewing the user guide: `help`](#help)
  - [Mode Switch: `mode`](#mode-switch)
  - [Timetable Mode](#Timetable-mode)
    - [Adding task: `add`](#adding-a-task)
    - [Listing tasks: `list`](#listing-tasks-list)
        - [Listing all tasks](#listing-all-tasks)
        - [Listing done tasks](#listing-done-tasks)
        - [Listing undone tasks](#listing-undone-tasks)
        - [Listing urgent tasks](#listing-urgent-tasks)
    - [Deleting a task: `delete`](#deleting-a-task-delete)
  - [Notebook Mode](#notebook-mode)
    - [Add contents: `add`](#add-feature-add)
        - [Adding a notebook](#adding-a-notebook)
        - [Adding a section](#adding-a-section)
        - [Adding a page](#adding-a-page)
    - [Select contents: `select`](#select-feature-select)
    - [List contents: `list`](#listing-contents-list)
        - [In the notebook mode](#in-the-notebook-mode)
        - [In a selected notebook ](#in-a-selected-notebook)
        - [In a selected section](#in-a-selected-section)
    - [Delete contents: `delete`](#delete-feature-delete)
- [Command Summary](#command-summary)

## Introduction

Zer0Note is a note taking and organisation application that combines the ease of use and feature set of graphical tools with the interaction speed of command-line based tools like vim and emacs.

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `Zer0Note` from [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Zer0Note.
4. Double click the file to start the app.
5. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window.

## Features

>:exclamation: Notes about the format:
* Words within `[square brackets]` are the expected user inputs.
  e.g. in `add /n[NOTEBOOK]`, `NOTEBOOK` is a parameter which can be used as `add /nCS2101`
* Within a code segment, ">>>" denotes the command typed by the user.
  e.g.  >>>select /sChapter 1
        now in notebook section: Chapter 1
  `select /sChapter 1` is the user's input, and `now in notebook section: Chapter 1` is the output message.      

### Viewing help : `help`

To view the full user guide, type in `help`.

To view the user guide for the timetable mode, type in `help timetable`.

To view the user guide for the notebook mode, type in `help notebook`.

### Switching between the two modes : `mode`
Switches from notebook mode (at the bookshelf level) to the timetable mode or vice versa.

- Switch to the notebook mode

Format: `mode /n`

- Switch to the timetable mode

Format: `mode /t`

### Timetable Mode
The Timetable Mode allows you to manage a list of tasks.
The following sections explains the various features you can use while you are in the Timetable Mode.

#### Adding a task
Adds a `task` with a `deadline` to the task list.

Format: `add /t[TASK] /by[dd-MM-yyyy] [hhmm]`

* `TASK`: name of the task.
* `dd-MM-yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

Example of usage:
`add /tRead book /by19-10-2020 1800`

Expected output:
```
Added: coding
1:[x] Read book (by: Oct 19 2020 06.00 PM)
```

### Listing tasks: `list`

#### Listing all tasks
Lists out all the existing tasks.

Format: `list`

Example of usage:

```
>>> list
1:[o] Read book (by: Oct 19 2020 06.00 PM)
2:[x] Return book (by: Oct 23 2020 12.00 PM)
3:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
4:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
5:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

#### Listing done tasks
Lists out all the tasks that are marked as done.

Format: `list /d`

Example of usage:

```
>>> list /d
1:[o] Read book (by: Oct 19 2020 06.00 PM)
2:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

#### Listing undone tasks
Lists out all the tasks that are not marked as done.

Format: `list /u`

Example of usage:

```
>>> list /u
1:[x] Return book (by: Oct 23 2020 12.00 PM)
2:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
3:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
```

#### Listing urgent tasks
Lists out top urgent tasks that has not been done, sorted by deadlines. If there are many undone tasks, top three urgent ones will be displayed.

Format: `list /urgent`

Example of usage:

```
>>> list /urgent
1:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
2:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
3:[x] Return book (by: Oct 23 2020 12.00 PM)
```
#### Deleting a task: `delete`
Deletes an existing task from the task list.

Format: `delete [INDEX]`

* `INDEX` refers to the index number of the intended task in the full task list

Example of usage:
`delete 1`

Expected output:
```
Noted. I've removed this task:
[x] Read book (by: Oct 19 2020 06.00 PM)
	Now you have 4 tasks in the list.
```

### Notebook Mode
In `Notebook mode`, you can manage a shelf of notebooks.
Each notebook contains sections, and each section contains pages. Each page holds your type-written notes.

#### Add Feature: `add`
##### Adding a notebook
Adds a `notebook`  into the `notebook shelf`.

Format: `add /n[NOTEBOOK]`

* `NOTEBOOK`: the name of the notebook.

Example of usage:
`add /nCS2101`

Expected output:
`Added notebook with title: CS2101`

##### Adding a section
Adds a `section`  into the [selected](#select-feature-select) `notebook`.
>:exclamation: You must select a `notebook` before adding a section!

Format: `add /s[SECTION]`

* `SECTION`: the name of the section in the selected `notebook`.

Example of usage:
`add /sW1: Java`

Expected output:
`Added section with title: W1: Java`

##### Adding a page
Adds a `page`  into the [selected](#select-feature-select) `section`.
>:exclamation: You must select a `section` before adding a page!

Format: `add /p[PAGE]; [PAGE CONTENT]`

* `PAGE`: the name of the page in the selected `section`.
* `PAGE CONTENT`: the contents that you would like to store in the `page`.

Example of usage:
`add /pHELLO WORLD; System.out.println("Hello World!");`

Expected output:
`Added page with title: HELLO WORLD`

#### Select Feature: `select`
Select a `notebook`, `section`, `page` or a combination of the three.

Format: `select /n[NOTEBOOK] /s[SECTION] /p[NUMBER]`

* `NOTEBOOK`: the title of the expected `notebook`.
* `SECTION`: the title of the expected `section` in `notebook`.
* `NUMBER`: the page number in the expected `section`.

Examples of usage:
In *NOTEBOOK MODE*,
* `select /nCS2101 /sW2 /p1` - selects page 1 in the notebook `CS2101`, under the section `W2`.
* `select /nCS2101 /sW2` - selects section titled `W2` in the notebook `CS2101`.
* `select /nCS2101` - selects the notebook titled `CS2101`.
* `select /all` - navigates back into `NOTEBOOK MODE`, where you can list to see all available notebooks.
> These commands can be run anywhere(i.e in a selected notebook or section) once you're in NOTEBOOK MODE.  

In a selected *NOTEBOOK*,
* `select /s1: What is OOP? /p1` - selects page 1 in the section `1: What is OOP?`, in the selected `notebook`.
* `select /s1: What is OOP?` - selects the section entitled `1: What is OOP?` in the selected `notebook`.

In a selected *SECTION*,
* `select /p1` - selects page 1 in the selected `section`.

### Listing contents: `list`
Lists out the content of the bookshelf, a selected book or a selected section.

Format: `list (/s) (/a)`

- `list` display contents in one level below the current selected object
- `list /s` display the notebooks together with titles of sections in NOTEBOOK mode
- `list /a` display all notebooks, sections and pages.

#### In the *notebook* mode:

- `list` displays the titles of notebooks in the shelf.
- `list /s` displays the titles of notebooks together with titles of sections.
- `list /a` displays all notebooks, sections and pages.

Example of usage:

```
>>>list
* CS2113
* CG2271
* CS2101

>>>list /s
* CS2113
  |-- Chapter 1
  |-- Chapter 2
* CG2271
* CS2101
  |-- Chapter 1
  |-- Chapter 2
  |-- Chapter 3

>>>list /a
* CS2113
  |-- Chapter 1
  |-- Chapter 2
* CG2271
* CS2101
  |-- Chapter 1
        |-- Writing email
            Lorem ipsum
        |-- Team meeting
            Lorem ipsum
  |-- Chapter 2
  |-- Chapter 3
```

#### In a selected notebook:

- `list` displays the titles of all the sections in the selected notebook.
- `list /a` displays all sections and pages in the selected notebook.

Example of usage:
```
>>>select /nCS2101
now in notebook book: CS2101
>>>list
* Chapter 1
* Chapter 2
* Chapter 3

>>>list /a
* Chapter 1
  |-- Writing email
        Lorem ipsum
  |-- Team meeting
        Lorem ipsum
* Chapter 2
* Chapter 3
```

#### In a selected section:

- `list` displays all the pages in the selected section.

Example of usage:

```
>>>select /sChapter 1
now in notebook section: Chapter 1
>>>list
* Writing email
    Lorem ipsum
* Team meeting
    Lorem ipsum
```

#### Delete Contents: `delete`
Deletes an existing notebook, section or page.
>:exclamation: The current selection determines the type you can delete.

Format: `delete /n[NOTEBOOK] /s[SECTION] /p[NUMBER]`

* `NOTEBOOK`: the title of the notebook to be deleted
* `SECTION`: the title of the section to be deleted in the selected `NOTEBOOK`
* `NUMBER`: the page number of the page to be deleted in the selected `SECTION`.

In *NOTEBOOK MODE*,
Examples of usages:
* `delete /nCS2113T /sW10 /p1` deletes page `1` under the section `W10` of the notebook `CS2113T`.
* `delete /nCS2113T /sW10` deletes the entire section titled `W10` in the notebook `CS2113T`.
* `delete /nCS2113T` deletes the entire notebook titled `CS2113T`.

In a selected *NOTEBOOK*,
* `delete /s1: What is OOP? /p1` deletes page `1` of the section titled `1: What is OOP?` of the selected notebook.
* `delete /s1: What is OOP?` deletes the section titled `1: What is OOP?` of the selected notebook.

In a selected *SECTION*,
* `delete /p1` deletes page `1` of the selected section.

The following example shows the output when deleting from the *notebook mode*.
Expected output:
```
>>> mode /n
You are now in notebook mode
>>> delete /nCS2113T /sW10 /p1
Noted. I've removed this page: HELLO WORLD
System.out.println("Hello World!")
>>> delete /nCS2113T /sW10
Noted. I've removed this section:
	W10
>>> delete /nCS2113T
Noted. I've removed this notebook:
    CS2113T
```

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## Command Summary
{Give a 'cheat sheet' of commands here}

### Timetable Mode

**Command** | **Format** | **Example**
----------- | ---------- | -----------
Add a task: `add` | add /tTASK /by[dd-MM-yyyy] [hhmm] | add /tcoding /by19-10-2020 1705
List tasks: `list` | list (/u) (/d) (/urgent) |
Delete: `delete` | delete [INDEX] | delete 1
Switch to notebook mode: `mode` | mode /n |

### Notebook Mode

**Command** | **Format** | **Example**
----------- | ---------- | -----------
Add: `add` | 1) add /nNOTEBOOK 2) add /sSECTION 3) add /pPAGE; CONTENT | add /nCS2101
Select: `select` | 1) select /nNOTEBOOK 2) select /sSECTION 3) select /pNUMBER | select /nCS2101
List contents: `list` | list (/s) (/a) |
Delete: `delete` | 1) select /nNOTEBOOK /sSECTION /pNUMBER | select /nCS2113T /sW10 /p1
Switch to timetable mode: `mode` | mode /t |
