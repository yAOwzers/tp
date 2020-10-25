# User Guide

## Table of Contents
[1. Introduction](#1-introduction) <br>
&nbsp;&nbsp;[1.1. About](#11-about) <br>
[2. Quick Start](#2-quick-start) <br>
[3. Features](#3-features) <br>
&nbsp;&nbsp;[3.1 Viewing the user guide: `help`](#31-viewing-the-user-guide-help) <br>
&nbsp;&nbsp;[3.2 Switching between the two modes: `mode`](#32-switching-between-the-two-modes-mode) <br>
&nbsp;&nbsp;[3.3 Timetable Mode](#33-timetable-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.1 Adding a task: `add`](#331-adding-a-task-add) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.2 Marking a task as done: `done`](#332-marking-a-task-as-done-done) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3 Listing tasks: `list`](#333-listing-tasks-list) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3.1 Listing all tasks](#3331-listing-all-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3.2 Listing done tasks](#3332-listing-done-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3.3 Listing undone tasks](#3333-listing-undone-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3.4 Listing urgent tasks](#3334-listing-urgent-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4. Deleting a task: `delete`](#334-deleting-a-task-delete) <br>
&nbsp;&nbsp;[3.4 Notebook Mode](#34-notebook-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1 Add contents: `add`](#341-add-feature-add) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.1 Adding a notebook](#3411-adding-a-notebook) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.2 Adding a section](#3412-adding-a-section) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.3 Adding a page](#3413-adding-a-page) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.2 Selecting contents: `select`](#342-selecting-feature-select) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.3 Listing contents: `list`](#343-listing-contents-list) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.4 Deleting contents: `delete`](#344-deleting-contents-delete) <br>
&nbsp;&nbsp;[3.5 Exiting the program: `exit`](#35-exiting-the-program-exit) <br>
[4. FAQ](#4-faq) <br>
[5. Command Summary](#5-command-summary) <br>

## 1. Introduction

**Zer0Note** is a note taking and organisation application meant for students(especially those who can type fast). It combines the features of note-taking apps (like OneNote) with the interaction speed of command-line based tools like vim and emacs. It helps students (like yourself!) to keep track of deadlines and take notes quickly. 

**Zer0Note** can operate in two different modes: 
1. Timetable Mode
2. Notebook Mode

### 1.1 About
This app is targeted towards students, especially those who enjoy typing! This user guide will give you a step-by-step tutorial on how to use each of the commands. By using these commands, you will be able to keep track of your deadlines and notes!

> Here are some icons that will be used in this User Guide: 
>> :exclamation: : Thing(s) to note
>>
>> :bulb: : Tip(s)

> :exclamation: Notes about the format:
* Words/sections that look like this: `example`, are code snippets.
* Words/phrases within `[square brackets]` are the expected user inputs.
  e.g. in `add /n[NOTEBOOK]`, `NOTEBOOK` is a parameter which can be used as `add /nCS2101`
* Words within `(parentheses)` are optional user inputs.
  e.g. in `list (/urgent)`, `/urgent` is an optional parameter.
* Within a code segment, `>>>` denotes the command typed by the user.

 Example:  
  ```
  >>> select /sChapter 1
        now in notebook section: Chapter 1
  ```

> `select /sChapter 1` is the user's input, and `now in notebook section: Chapter 1` is the output message.      


## 2. Quick Start

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `Zer0Note` from [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Zer0Note.
4. Open a terminal on your computer and navigate to the folder containing the jar file. In the following example, the file has been saved in the Downloads folder.

    ![Change directory](/images/command-change-dir.png)
 
    Figure 1. Changing directory in Windows command prompt

5. Type `java -jar Zer0Note.jar` and press Enter.
6. If successful, you will see the following message.

    ![Welcome message](/images/welcome.png) 

    Figure 2. Welcome message on successful run

Great! Now that you have successfully run Zer0Note, go ahead and try out the different commands available (shown in the next section, 3. Features).

## 3. Features

The following sections will explain more about the different commands that can be used in anywhere, 
and commands specific to [Timetable Mode](#33-timetable-mode) and [Notebook Mode](#34-notebook-mode).


### 3.1 Viewing the user guide: `help`

To view the full user guide, type in `help`.

To view the user guide for the timetable mode, type in `help timetable`.

To view the user guide for the notebook mode, type in `help notebook`.

### 3.2 Switching between the two modes: `mode`

Switches from notebook mode (at the bookshelf level) to the timetable mode or vice versa.

- Switch to the notebook mode

Format: `mode /n`

- Switch to the timetable mode

Format: `mode /t`

## 3.3 Timetable Mode

Keeping up with deadlines may seem like a daunting task, especially when you're already busy with school. 
With Zer0Note's Timetable Mode, you'll be able to manage a list of tasks. 
You can `add`, `delete`, `list` and mark your deadlines as `done`!
The following sections explain the various features you can use while you are in the Timetable Mode.

### 3.3.1 Adding a task: `add`
This command adds a task with a `deadline` to the task list. 

Format: `add /t[TASK] /by[dd-MM-yyyy] [hhmm]`

* `TASK`: name of the task.
* `dd-MM-yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

Example of usage:
Let's say you have to read a book for one of your modules. 

```
>>> add /tRead book /by19-10-2020 1800
Added: coding
1:[x] Read book (by: Oct 19 2020 06.00 PM)
```

### 3.3.2 Marking a task as done: `done`
Marks an existing `task` as done in the current task list.

Format: `done [INDEX]`

* `INDEX`: Index of the existing task in the current task list.

Example of usage:

```
>>> done 1
Yay! I've marked this task as done:
 [o] Read book
```

### 3.3.3 Listing tasks: `list`

#### 3.3.3.1 Listing all tasks
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

#### 3.3.3.2 Listing done tasks
Lists out all the tasks that are marked as done.

Format: `list /d`

Example of usage:

```
>>> list /d
1:[o] Read book (by: Oct 19 2020 06.00 PM)
2:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

#### 3.3.3.3 Listing undone tasks
Lists out all the tasks that are not marked as done.

Format: `list /u`

Example of usage:

```
>>> list /u
1:[x] Return book (by: Oct 23 2020 12.00 PM)
2:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
3:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
```

#### 3.3.3.4 Listing urgent tasks
Lists out top urgent tasks that has not been done, sorted by deadlines. If there are many undone tasks, top three urgent ones will be displayed.

Format: `list /urgent`

Example of usage:

```
>>> list /urgent
1:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
2:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
3:[x] Return book (by: Oct 23 2020 12.00 PM)
```
### 3.3.4 Deleting a task: `delete`
Deletes an existing task from the task list.

Format: `delete [INDEX]`

* `INDEX` refers to the index number of the intended task in the full task list

Example of usage:

```
>>> delete 1
Noted. I've removed this task:
[x] Read book (by: Oct 19 2020 06.00 PM)
	Now you have 4 tasks in the list.
```

## 3.4 Notebook Mode
In `Notebook mode`, you can manage a shelf of notebooks.
Each notebook contains sections, and each section contains pages. Each page holds your type-written notes.

### 3.4.1 Add Feature: `add`
#### 3.4.1.1 Adding a notebook
Adds a `notebook`  into the `notebook shelf`.

Format: `add /n[NOTEBOOK]`

* `NOTEBOOK`: the name of the notebook.

Example of usage:

```
>>> add /nCS2101
Added notebook with title: CS2101
```

#### 3.4.1.2 Adding a section
Adds a `section`  into the [selected](#342-select-feature-select) `notebook`.
>:bulb: You must select a `notebook` before adding a section!

Format: `add /s[SECTION]`

* `SECTION`: the name of the section in the selected `notebook`.

Example of usage:

```
>>> add /sW1: Java
Added section with title: W1: Java
```

#### 3.4.1.3 Adding a page
Adds a `page`  into the [selected](#342-select-feature-select) `section`.
>:bulb: You must select a `section` before adding a page!

Format: `add /p[PAGE]; [PAGE CONTENT]`

* `PAGE`: the name of the page in the selected `section`.
* `PAGE CONTENT`: the contents that you would like to store in the `page`.

Example of usage:

```
>>> add /pHELLO WORLD; System.out.println("Hello World!");
Added page with title: HELLO WORLD
```

### 3.4.2 Selecting Feature: `select`
Select a `notebook`, `section`, `page` or a combination of the three.

Format: `select /n[NOTEBOOK] /s[SECTION] /p[NUMBER]`

* `NOTEBOOK`: the title of the expected `notebook`.
* `SECTION`: the title of the expected `section` in `notebook`.
* `NUMBER`: the page number in the expected `section`.

In *NOTEBOOK MODE*:
* `select /nCS2101 /sW2 /p1` - selects page 1 in the notebook `CS2101`, under the section `W2`.
* `select /nCS2101 /sW2` - selects section titled `W2` in the notebook `CS2101`.
* `select /nCS2101` - selects the notebook titled `CS2101`.
* `select /all` - navigates back into `NOTEBOOK MODE`, where you can list to see all available notebooks.
> These commands can be run anywhere(i.e in a selected notebook or section) once you're in NOTEBOOK MODE.  

In a selected *NOTEBOOK*:
* `select /s1: What is OOP? /p1` - selects page 1 in the section `1: What is OOP?`, in the selected `notebook`.
* `select /s1: What is OOP?` - selects the section entitled `1: What is OOP?` in the selected `notebook`.

In a selected *SECTION*:
* `select /p1` - selects page 1 in the selected `section`.

Example of usage:

```
>>> select /nCS2101
now in notebook book: CS2101
```

### 3.4.3 Listing contents: `list`
Lists out the content of the bookshelf, a selected book or a selected section.

Format: `list (/s) (/a)`

- `list` display contents in one level below the current selected object
- `list /s` display the notebooks together with titles of sections in NOTEBOOK mode
- `list /a` display all notebooks, sections and pages.

In *NOTEBOOK MODE*,
- `list` displays the titles of notebooks in the shelf.
- `list /s` displays the titles of notebooks together with titles of sections.
- `list /a` displays all notebooks, sections and pages.

Example of usage:

```
>>> list
* CS2113
* CG2271
* CS2101

>>> list /s
* CS2113
  |-- Chapter 1
  |-- Chapter 2
* CG2271
* CS2101
  |-- Chapter 1
  |-- Chapter 2
  |-- Chapter 3

>>> list /a
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

In a selected *NOTEBOOK*:
- `list` displays the titles of all the sections in the selected notebook.
- `list /a` displays all sections and pages in the selected notebook.

Example of usage:
```
>>> select /nCS2101
now in notebook book: CS2101
>>>list
* Chapter 1
* Chapter 2
* Chapter 3

>>> list /a
* Chapter 1
  |-- Writing email
        Lorem ipsum
  |-- Team meeting
        Lorem ipsum
* Chapter 2
* Chapter 3
```

In a selected *SECTION*:
- `list` displays all the pages in the selected section.

Example of usage:

```
>>> select /sChapter 1
now in notebook section: Chapter 1
>>> list
* Writing email
    Lorem ipsum
* Team meeting
    Lorem ipsum
```

### 3.4.4 Deleting contents: `delete`
Deletes an existing notebook, section or page.
> :exclamation: The current selection determines the type you can delete.

Format: `delete /n[NOTEBOOK] /s[SECTION] /p[NUMBER]`

* `NOTEBOOK`: the title of the notebook to be deleted
* `SECTION`: the title of the section to be deleted in the selected `NOTEBOOK`
* `NUMBER`: the page number of the page to be deleted in the selected `SECTION`.

In *NOTEBOOK MODE*,
* `delete /nCS2113T /sW10 /p1` deletes page `1` under the section `W10` of the notebook `CS2113T`.
* `delete /nCS2113T /sW10` deletes the entire section titled `W10` in the notebook `CS2113T`.
* `delete /nCS2113T` deletes the entire notebook titled `CS2113T`.

In a selected *NOTEBOOK*,
* `delete /s1: What is OOP? /p1` deletes page `1` of the section titled `1: What is OOP?` of the selected notebook.
* `delete /s1: What is OOP?` deletes the section titled `1: What is OOP?` of the selected notebook.

In a selected *SECTION*,
* `delete /p1` deletes page `1` of the selected section.

Example of usage:

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

### 3.5 Exiting the program: `exit`

To terminate the program, type `exit`.

## 4. FAQ

This section answers some frequently asked questions. 

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## 5. Command Summary

This section lists all the commands available in **Zer0Note**! There are general commands that can be used anywhere, as well as commands that are specific to the mode you are in!
> :bulb: You can click on each of the commands to navigate to its section.

### General Commands

The following table shows you a list of commands that can be used anywhere, and in any mode.

###### Table: Commands that can be used anywhere

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Help](#31-viewing-the-user-guide-help): `help` | 1) help 2) help timetable 3) help notebook |
[Exit](#35-exit-the-program-exit) `exit` | exit |


### Timetable Mode

The following table is a cheatsheet of the commands available in Timetable Mode.

###### Table: Cheatsheet of the commands available in Timetable Mode 

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add a task](#331-adding-a-task-add): `add` | add /tTASK /by[dd-MM-yyyy] [hhmm] | add /tcoding /by19-10-2020 1705
[Mark a task as done](#332-marking-a-task-as-done-done): `done` | done [INDEX] | done 1
[List tasks](#333-listing-tasks-list): `list` | list (/u) (/d) (/urgent) |
[Delete](#334-deleting-a-task-delete): `delete` | delete [INDEX] | delete 1
[Switch to notebook mode](#32-switching-between-the-two-modes-mode): `mode` | mode /n |

### Notebook Mode

The following table is a cheatsheet of the commands available in Notebook Mode.

###### Table: Cheatsheet of the commands available in Notebook Mode

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add](#341-add-feature-add): `add` | 1) add /nNOTEBOOK 2) add /sSECTION 3) add /pPAGE; CONTENT | add /nCS2101
[Select](#342-select-feature-select): `select` | 1) select /nNOTEBOOK 2) select /sSECTION 3) select /pNUMBER | select /nCS2101
[List contents](#343-listing-contents-list): `list` | list (/s) (/a) |
[Delete](#344-delete-contents-delete): `delete` | 1) select /nNOTEBOOK /sSECTION /pNUMBER | select /nCS2113T /sW10 /p1
[Switch to timetable mode](#32-switching-between-the-two-modes-mode): `mode` | mode /t |
