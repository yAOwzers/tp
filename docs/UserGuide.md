# Zer0Note User Guide

```
          Welcome to
 ______    _ _ _                  _ _ _   _    _            _
|      |  |_ _  |   _ _    _  _  |  _  | |  \ | |   _ _   _| |_    _ _
| 0 u 0|    /  /  /  _  \ | |/_\ | | | | |   \| |  /   \ |_   _| /   _ \
|      |   /  /_  |  _ _/ | |    | |_| | |  |\  | |  [] |  | |_  |  _ _/
|______|  |_ _ _|  \ _ _| |_|    |_ _ _| | _| \_|  \ _ /   |_ _|  \ _ _|
```

## Table of Contents
[**1. Introduction**](#1-introduction) <br>
&nbsp;&nbsp;[1.1. About](#11-about) <br>
[**2. Quick Start**](#2-quick-start) <br>
[**3. Features**](#3-features) <br>
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
[**4. FAQ**](#4-faq) <br>
[**5. Command Summary**](#5-command-summary) <br>

## 1. Introduction

Welcome, and thank you for choosing **Zer0Note**!

**Zer0Note** is a note taking and organisation application meant for students(especially those who can type fast).
It combines the features of note-taking apps (like OneNote) with the interaction speed of command-line based tools like vim and emacs.
It helps students (like yourself!) to keep track of deadlines and take notes quickly.

**Zer0Note** is designed for students who love typing, and the command line! 

This document contains all the information you need to get started with using Zer0Note. It contains an exhaustive
guide to all the features in the application. A condensed version of this guide is available inside the application
too, for quick reference while you're using **Zer0Note**. To learn how to access the built-in user guide, see
[Section 3.1](#31-viewing-the-user-guide-help). 
 


### 1.1 How to use this guide

This user guide will give you a step-by-step tutorial on how to use each of the commands.
By using these commands, you will be able to keep track of your deadlines and organise your notes!

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
* Words in [blue]() are clickable links.

## 2. Quick Start

1. Ensure that you have Java 11 or above installed. You may use the 
[Oracle Java SE runtime](https://www.oracle.com/java/technologies/javase-downloads.html) 
or an open-source alternative like [AdoptOpenJDK](https://adoptopenjdk.net/index.html). 
1. Download the latest version of `Zer0Note` from [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases).
1. Copy the file to the folder you want to use as the home folder for Zer0Note.
1. Open a terminal on your computer and navigate to the folder containing the jar file. In the following example, the
 file has been saved in the Downloads folder.

    ![Change directory](/images/command-change-dir.png)

    Figure 1. Changing directory in Windows command prompt

1. Type `java -jar Zer0Note.jar` and press Enter.
1. If successful, you will see the following message.

    ![Welcome message](/images/welcome.png)

    Figure 2. Welcome message on successful run

Great! Now that you have successfully run Zer0Note, go ahead and try out the different commands available (shown in the next section, 3. Features).

## 3. Features

**Zer0Note** can operate in two different modes:
1. Timetable Mode
2. Notebook Mode

The following sections will explain more about the different commands that can be used in anywhere,
and commands specific to [Timetable Mode](#33-timetable-mode) and [Notebook Mode](#34-notebook-mode).

### 3.1 Viewing the user guide: `help`

Whenever you need help, you can view the full built-in user guide by typing in `help`.

To view the user guide for the timetable mode, type in `help timetable`.

To view the user guide for the notebook mode, type in `help notebook`.

### 3.2 Switching between the two modes: `mode`

This command allows you to switch from notebook mode (at the bookshelf level) to the timetable mode, or vice versa.

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

This command lets you `add` a `task` with a deadline to the task list.

Format: `add /t[TASK] /by[dd-MM-yyyy] [hhmm]`

* `TASK`: name of the task.
* `dd-MM-yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

Example of usage:
Let's say you have to read a book for one of your modules.

```
>>> add /tRead book /by19-10-2020 1800
Added: Read Book
1:[x] Read book (by: Oct 19 2020 06.00 PM)
```

With that, you've successfully added a task titled `Read book`, with the deadline `Oct 19 2020 06.00 PM` into your task list!

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

Use the `list` command to list the tasks you have added to **Zer0Note**. There are a number of ways you can use this
command, described below: 

#### 3.3.3.1 Listing all tasks

When you want to have a look at your task list, you can list out all the existing tasks.

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

When you want to keep track of your progress, you can list out all the tasks that are marked as done.

Format: `list /d`

Example of usage:

```
>>> list /d
1:[o] Read book (by: Oct 19 2020 06.00 PM)
2:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

#### 3.3.3.3 Listing undone tasks

If you want to have a look at what you need to do, you can list out all the tasks that are not marked as done.

Format: `list /u`

Example of usage:

```
>>> list /u
1:[x] Return book (by: Oct 23 2020 12.00 PM)
2:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
3:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
```

#### 3.3.3.4 Listing urgent tasks

If you're in a time crunch, you can list out top urgent tasks that have not been done, sorted by deadlines. If there
are many undone tasks, only the top three urgent ones will be displayed.

Format: `list /urgent`

Example of usage:

```
>>> list /urgent
1:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
2:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
3:[x] Return book (by: Oct 23 2020 12.00 PM)
```
### 3.3.4 Deleting a task: `delete`

Use the `delete` command to delete tasks you previously added to **Zer0Note**. 

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

In a semester, an average student takes about 4-5 modules. You can use **Zer0Note** to keep all your notes and
thoughts about all those different classes in one place. This can help you organise your thoughts better!

In `Notebook Mode`, you can manage a shelf of notebooks.
You can name it however you like and create as many notebooks you wish!
Each notebook contains sections, and each section contains pages. Each page holds your type-written notes.

For example, you can keep one notebook for each module you take, one section for each week or
lecture, and pages for different concepts.  

### 3.4.1 Add Feature: `add`

Within `Notebook Mode`, you can `add` a `notebook`, `section` or a `page`. This section will guide you through these commands.

#### 3.4.1.1 Adding a notebook

Use the `add /n` command to add a `notebook`  into the `notebook shelf`.

Format: `add /n[NOTEBOOK]`

* `NOTEBOOK`: the name of the notebook.

Example of usage:

```
>>> add /nCS2101
Added notebook with title: CS2101
```

#### 3.4.1.2 Adding a section

Use the `add /s` command to add a `section`  into the [selected](#342-select-feature-select) `notebook`.

>:bulb: You must select a `notebook` before adding a section!

Format: `add /s[SECTION]`

* `SECTION`: the name of the section in the selected `notebook`.

Example of usage:

```
>>> add /sW1: Java
Added section with title: W1: Java
```

#### 3.4.1.3 Adding a page

Use the `add /p` command to add a `page`  into the [selected](#342-select-feature-select) `section`.
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

After adding a `notebook`, `section` or `page`, you may want to view its contents.
Use the `select` command to select a `notebook`, `section`, `page` or a combination of the three.
> :bulb: When you want to `add` a `section`, you must select a `notebook` first.
> :bulb: When you want to `add` a `page`, you must select a `section` first.

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

Use the `list` command to view the content of the bookshelf, a selected book or a selected section.

Format: `list (/s) (/a)`

- `list` display contents in one level below the current selected object
- `list /s` display the notebooks together with titles of sections in NOTEBOOK mode
- `list /a` display all notebooks, sections and pages.

In *NOTEBOOK MODE*,
- `list` displays the titles of notebooks in the shelf.
- `list /s` displays the titles of notebooks together with titles of sections.
- `list /a` displays all notebooks, sections and pages.

Examples of usage:

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

Examples of usage:
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

Use the `delete` command to delete an existing notebook, section or page.

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

Examples of usage:

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

To close the program, type `exit`.

## 4. FAQ

This section answers some frequently asked questions.

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## 5. Command Summary

This section lists all the commands available in **Zer0Note**! There are general commands that can be used anywhere, as well as commands that are specific to the mode you are in!
> :bulb: You can click on each of the commands to navigate to its section.

### General Commands

The following table shows you a list of commands that can be used anywhere, and in any mode.

#### Table: Commands that can be used anywhere

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Help](#31-viewing-the-user-guide-help): `help` | 1) help 2) help timetable 3) help notebook |
[Exit](#35-exit-the-program-exit) `exit` | exit |


### Timetable Mode

The following table is a cheatsheet of the commands available in Timetable Mode.

#### Table: Cheatsheet of the commands available in Timetable Mode

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add a task](#331-adding-a-task-add): `add` | add /tTASK /by[dd-MM-yyyy] [hhmm] | add /tcoding /by19-10-2020 1705
[Mark a task as done](#332-marking-a-task-as-done-done): `done` | done [INDEX] | done 1
[List tasks](#333-listing-tasks-list): `list` | list (/u) (/d) (/urgent) |
[Delete](#334-deleting-a-task-delete): `delete` | delete [INDEX] | delete 1
[Switch to notebook mode](#32-switching-between-the-two-modes-mode): `mode` | mode /n |

### Notebook Mode

The following table is a cheatsheet of the commands available in Notebook Mode.

#### Table: Cheatsheet of the commands available in Notebook Mode

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add](#341-add-feature-add): `add` | 1) add /nNOTEBOOK 2) add /sSECTION 3) add /pPAGE; CONTENT | add /nCS2101
[Select](#342-select-feature-select): `select` | 1) select /nNOTEBOOK 2) select /sSECTION 3) select /pNUMBER | select /nCS2101
[List contents](#343-listing-contents-list): `list` | list (/s) (/a) |
[Delete](#344-delete-contents-delete): `delete` | 1) select /nNOTEBOOK /sSECTION /pNUMBER | select /nCS2113T /sW10 /p1
[Switch to timetable mode](#32-switching-between-the-two-modes-mode): `mode` | mode /t |

## 6. For advanced users: Editing your save file

**Zer0Note** saves your tasks as a plain text file, in a format designed to be easy to read, understand and modify if
you so desire. We realise that power users may wish to use a different text editor such as vim or Visual Studio Code
to edit their notes, while also taking advantage of the organisation features of Zer0Note. If you wish to edit the
save file by yourself, here's a detailed guide on the contents of the save file and how to edit it. 

> :exclamation: **Zer0Note** is very sensitive to the format of the saved file! If there are any errors in the save
> file, **Zer0Note** will not load it at all, since it cannot be sure if any of the file is uncorrupted. Proceed with
> caution!

### 6.1. The tasks save file

The tasks save file is formatted as follows. 

First, one line containing only an integer number `n` indicating the number of tasks in the list. 

This is followed by `n` sets of 3 lines each. The first line contains the name of the task. The second line contains
the deadline of the task, in the format `dd-MM-YYYY hhmm`. The third line contains a value `true` or `false`, 
indicating whether the task is done. `true` means it is done, `false` means it is not done. 

Here is an example of the contents of a tasks save file:

```
3
Code for CS2113T Team Project
10-11-2020 1200
false
Read about hydrogen fuel cells
22-11-2020 1234
true
Read Book
19-10-2020 1800
false
```

### 6.2. The notebooks save file

The notebooks save file is formatted as follows. 

First, one line containing only an integer number `n` indicating the number of notebooks on the shelf. 

This is followed by `n` sets of lines, describing each of the `n` notebooks. The `i`th set describes the `i`th
notebook. 

The first line in the set contains the title of the `i`th notebook. 

The next line in the set contains only an integer number `s` indicating the number of sections in the `i`th notebook. 

This is followed by `s` sets of lines, describing each of the `s` sections in notebook `i`. The `j`th set describes
the `j`th section in the `i`th notebook.

The first line in the `j`th set contains the title of the `j`th section of the `i`th notebook. 

The next line in the set contains only an integer number `p` indicating the number of pages in the `j`th section of
 the `i`th notebook. 
 
This is followed by `p` sets of 2 lines each. The `k`th set describes the `k`th page, of the `j`th section, of the `i
`th notebook. 

The first line of the `k`th set contains the title of the page. 

The second line of the `k`th set contains the content of the page. The newline characters in the content of the
page are replaced by `~~~`.  

Here is an example of a notebooks save file:

```
2
CS2113T
4
Java
2
What is Java?
Java is a programming language used by 3 billion devices. 
Why Java?
It's highly portable and relatively fast. 
OOP
1
What is OOP?
OOP is Object Oriented Programming. 
UML
2
What is UML?
UML is Unified Modeling Language. 
Why UML?
UML is used to draw diagrams to explain your code to noobs.
Assertions
1
Why assertions?
Honestly I don't know. 
CS2101
2
User Guides
2
What are UGs?
UGs are documents for the user to read to understand how to use the product
How to write UGs?
Be user focused. That's all. 
Developer Guides
3
What are DGs?
DGs are documents for the developer to understand how the program is written.
How to write DGs?
Make sure the level of technicality is appropriate. 
Diagrams
Make sure diagrams use UML. 
```