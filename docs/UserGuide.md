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
&nbsp;&nbsp;[1.1. How to use this guide](#11-how-to-use-this-guide) <br>
[**2. Quick Start**](#2-quick-start) <br>
[**3. Features**](#3-features) <br>
&nbsp;&nbsp;[3.1 Viewing the user guide: `help`](#31-viewing-the-user-guide-help) <br>
&nbsp;&nbsp;[3.2 Switching between the two modes: `mode`](#32-switching-between-the-two-modes-mode) <br>
&nbsp;&nbsp;[3.3 Timetable Mode](#33-timetable-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.1 Adding a task: `add`](#331-adding-a-task-add) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.2 Marking a task as done: `done`](#332-marking-a-task-as-done-done) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3 Tagging a task: `tag`](#333-tagging-tasks-tag) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4 Listing tasks: `list`](#334-listing-tasks-list) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4.1 Listing all tasks](#3341-listing-all-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4.2 Listing done tasks](#3342-listing-done-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4.3 Listing undone tasks](#3343-listing-undone-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4.4 Listing urgent tasks](#3344-listing-urgent-tasks) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.5 Finding tasks: `find`](#335-finding-tasks-find) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.5.1 Finding by keyword](#3351-finding-by-keyword) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.5.2 Finding by tag](#3352-finding-by-tag) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.3.6. Deleting a task: `delete`](#336-deleting-a-task-delete) <br>
&nbsp;&nbsp;[3.4 Notebook Mode](#34-notebook-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1 Adding a notebook/section/page: `add`](#341-adding-a-notebooksectionpage-add) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.1 Adding a notebook](#3411-adding-a-notebook) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.2 Adding a section](#3412-adding-a-section) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1.3 Adding a page](#3413-adding-a-page) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.2 Selecting a notebook/section/page: `select`](#342-selecting-a-notebooksectionpage-select) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.3 Tagging a notebook/section/page: `tag`](#343-tagging-a-notebooksectionpage-tag) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.4 Listing contents: `list`](#344-listing-contents-list) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.5 Finding contents: `find`](#345-finding-contents-find) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.5.1 Finding by keyword](#3351-finding-by-keyword) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.5.2 Finding by tag](#3452-finding-by-tag) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[3.4.6 Deleting a notebook/section/page: `delete`](#346-deleting-a-notebooksectionpage-delete) <br>
&nbsp;&nbsp;[3.5 Exiting the program: `exit`](#35-exiting-the-program-exit) <br>
[**4. FAQ**](#4-faq) <br>
[**5. Command Summary**](#5-command-summary) <br>
[**6. For advanced users: Editing your save file**](#6-for-advanced-users-editing-your-save-file)<br>
&nbsp;&nbsp;[6.1 The tasks save file](#61-the-tasks-save-file)<br>
&nbsp;&nbsp;[6.2 The notebooks save file](#62-the-notebooks-save-file)<br>

<br>

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

<br>

### 1.1 How to use this guide

This user guide will give you a step-by-step tutorial on how to use each of the commands.
By using these commands, you will be able to keep track of your deadlines and organise your notes!

Here are some icons that will be used in this User Guide:

*Table 1: Icons and their meanings*

**Icon** | **Meaning**
-------- | ----------
:exclamation: | This is a note. A note suggests some considerations when using Zer0Note.
:bulb: | This is a tip. A tip gives you a suggestion when using **Zer0Note**.
:warning: | This is a warning. A warning suggests that you **may** get an error.

<br>
<hr>

:exclamation: Notes about the format:
* Words/sections that look like this: `example`, are code snippets.
* Words/phrases within `[square brackets]` are the expected user inputs.
  e.g. in `add /n[NOTEBOOK]`, `NOTEBOOK` is a parameter which can be used as `add /nCS2101`
* Words within `(parentheses)` are optional user inputs.
  e.g. in `list (/urgent)`, `/urgent` is an optional parameter.
* Words in [blue]() are clickable links.
* Within a code segment, `>>>` denotes the command typed by the user.
    Example:  
    ```
    >>> select /sChapter 1
        now in notebook section: Chapter 1
    ```

  `select /sChapter 1` is the user's input, and `now in notebook section: Chapter 1` is the output message.      

<br>

## 2. Quick Start

Here is a list of instructions on how you can download Zer0Note!

1. Ensure that you have Java 11 or above installed. You may use the
[Oracle Java SE runtime](https://www.oracle.com/java/technologies/javase-downloads.html)
or an open-source alternative like [AdoptOpenJDK](https://adoptopenjdk.net/index.html).
2. Download the latest version of `Zer0Note` from [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Zer0Note.
4. Open a terminal on your computer and navigate to the folder containing the jar file. In the following example, the
 file has been saved in the Downloads folder.

    ![Change directory](images/command-change-dir.png)

    *Figure 1. Changing directory in Windows command prompt*

5. Type `chcp 65001` and press Enter.
6. Type `java -jar Zer0Note.jar` and press Enter.
7. If successful, you will see the following message.

    ![Welcome message](images/welcome.png)

    *Figure 2. Welcome message on successful run*

Great! Now that you have successfully run Zer0Note, go ahead and try out the different commands available (shown in section 3. Features).

<br>

## 3. Features

This section introduces the available features, and the format required for each of the commands.

**Zer0Note** can operate in two different modes:
1. Timetable Mode
2. Notebook Mode

The following sections will explain more about the different commands that can be used in anywhere,
and commands specific to [Timetable Mode](#33-timetable-mode) and [Notebook Mode](#34-notebook-mode).

<br>

### 3.1 Viewing the user guide: `help`

Whenever you need help, you can view the full built-in user guide by typing in `help`.

To view the user guide for the timetable mode, type in `help timetable`.

To view the user guide for the notebook mode, type in `help notebook`.

<br>

### 3.2 Switching between the two modes: `mode`

This command allows you to switch from notebook mode (at the bookshelf level) to the timetable mode, or vice versa.

- Switch to the notebook mode

Format: `mode /n`

- Switch to the timetable mode

Format: `mode /t`

<br>

### 3.3 Timetable Mode

Keeping up with deadlines may seem like a daunting task, especially when you're already busy with school.
With Zer0Note's Timetable Mode, you'll be able to manage a list of tasks.
You can `add`, `delete`, `list` and mark your deadlines as `done`!

For example, you can add your assignments with their due dates as tasks.
You can then mark them as done when you're finished with them, or delete them if you've made a mistake.

The following sections explain the various features you can use while you are in the Timetable Mode.

<br>

#### 3.3.1 Adding a task: `add`

This command lets you `add` a `task` with a deadline to the task list.

Format: `add /t[TASK] /by[dd-MM-yyyy] [hhmm]`

These are the parameters required in the command:

* `TASK`: name of the task.
* `dd-MM-yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

<br>

Example of usage:
Let's say you have to read a book for one of your modules.

```
>>> add /tRead book /by19-10-2020 1800
Added: Read Book
1:[x] Read book (by: Oct 19 2020 06.00 PM)
```

With that, you've successfully added a task titled `Read book`, with the deadline `Oct 19 2020 06.00 PM` into your task list!

>:warning: Please remember to type the deadline in the correct format, or else an error message will be shown.
> Both task titles and deadlines should not be blank!

<br>

#### 3.3.2 Marking a task as done: `done`

Marks an existing `task` as done in the current task list.

Format: `done [INDEX]`

This is the parameter required in the command:

* `INDEX`: Index of the existing task in the current task list.

<br>

Example of usage:

```
>>> done 1
Yay! I've marked this task as done:
 [o] Read book
```

<br>

#### 3.3.3 Tagging tasks: `tag`

You have added a few tasks, and completed some of them. Congratulations! After reviewing, you realise that some of the
tasks come from the same module, or that some are non-academic-related. Is there any way you can categorise them together?

This command lets you add a single `tag` to an existing `task` to remind you of the category it belongs to. You can
learn how to search for all tasks with the same `tag` in [Finding tasks](#335-finding-tasks-find).

>:bulb: Each task can only have one tag. The previous tag will be automatically overwritten by the new tag and no
>reminder will be given.
>
Format: `tag [INDEX] /t[TAG]`

These are the parameters required in the command:

* `INDEX`: index number of the intended task in the full task list
* `TAG`: text description of the tag

<br>

Example of usage:

```
>>> tag 1 /tTodo
Got it! I've tagged this as:
 [o] Read book (by: Oct 19 2020 06.00PM)(tag: Todo)
```

<br>

#### 3.3.4 Listing tasks: `list`

Use the `list` command to list the tasks you have added to **Zer0Note**. There are 4 ways you can use this
command, described below:

<br>

##### 3.3.4.1 Listing all tasks

When you want to have a look at your task list, you can list out all the existing tasks.

Format: `list`

<br>

Example of usage:

```
>>> list
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
2:[x] Return book (by: Oct 23 2020 12.00 PM)
3:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
4:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
5:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

<br>

##### 3.3.4.2 Listing done tasks

When you want to keep track of your progress, you can list out all the tasks that are marked as done.

Format: `list /d`

<br>

Example of usage:

```
>>> list /d
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
2:[o] CS2101 OP2 (by: Oct 25 2020 11.00 AM)
```

<br>

##### 3.3.4.3 Listing undone tasks

If you want to have a look at what you need to do, you can list out all the tasks that are not marked as done.

Format: `list /u`

<br>

Example of usage:

```
>>> list /u
1:[x] Return book (by: Oct 23 2020 12.00 PM)
2:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
3:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
```

<br>

##### 3.3.4.4 Listing urgent tasks

If you're in a time crunch, you can list out top urgent tasks that have not been done, sorted by deadlines. If there
are many undone tasks, only the top three urgent ones will be displayed.

Format: `list /urgent`

<br>

Example of usage:

```
>>> list /urgent
1:[x] Submit assignment (by: Oct 18 2020 04.00 PM)
2:[x] CS2113T Quiz (by: Oct 23 2020 11.00 PM)
3:[x] Return book (by: Oct 23 2020 12.00 PM)
```

<br>

#### 3.3.5 Finding tasks `find`

Your tasklist has grown, and it becomes a pain to go through every single task in the list. Filtering the list by
completion and deadline does not provide the intended result either. Don't worry! You can search for any task directly
too.

There are two ways to find a task:

##### 3.3.5.1 Finding by keyword

Finds any task that contains the keyword in the task description.  The search is not case-sensitive.

Format: `find [KEYWORD]`

These are the parameters required in the command:

* `KEYWORD`: keyword to look for

Example of usage:
```
>>> find book
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
2:[x] Return book (by: Oct 23 2020 12.00 PM)
```

##### 3.3.5.2 Finding by tag

Finds any task that has a specified tag.  The search is case-sensitive.

Format: `find /t[TAG]`

These are the parameters required in the command:

* `TAG`: tag to look for

Example of usage:
```
>>> find /tTodo
Here are the tasks I found:
1:[o] Read book (by: Oct 19 2020 06.00 PM)(tag: Todo)
```

#### 3.3.6 Deleting a task: `delete`

Use the `delete` command to delete tasks you previously added to **Zer0Note**.

Format: `delete [INDEX]`

This is the parameter required in the command:

* `INDEX`: index number of the intended task in the full task list

<br>

Example of usage:

```
>>> delete 1
Noted. I've removed this task:
[x] Read book (by: Oct 19 2020 06.00 PM)
	Now you have 4 tasks in the list.
```

<br>

### 3.4 Notebook Mode

In a semester, an average student takes about 4-5 modules. You can use **Zer0Note** to keep all your notes and
thoughts about all those different classes in one place. This can help you organise your thoughts better!

In `Notebook Mode`, you can manage a shelf of notebooks.
You can name it however you like and create as many notebooks you wish!
Each notebook contains sections, and each section contains pages. Each page holds your type-written notes.

For example, you can keep one notebook for each module you take, one section for each week or
lecture, and pages for different concepts.  

#### 3.4.1 Adding a notebook/section/page: `add`

Within `Notebook Mode`, you can `add` a `notebook`, `section` or a `page`. This section will guide you through these commands.

> :warning: This feature does not support adding a notebook, section and page (or any combination of the 3) 
> all at once. e.g. `add /nSchool /sAdmin /p1: Modules` will throw an error.

##### 3.4.1.1 Adding a notebook

Use the `add /n` command to add a `notebook`  into the `notebook shelf`.

> :warning: Please make sure not to use ";" in your notebook title!

Format: `add /n[NOTEBOOK]`

This is the parameter required in the command:

* `NOTEBOOK`: the name of the notebook.

<br>

Example of usage:

Let's say you want to take notes for CS2113T, a module you're currently taking.

```
>>> add /nCS2113T
Added notebook with title: CS2113T
```

>:warning: Ensure that your notebook title is preceded by "/n", or an error message will be shown.

Now that you have added a new notebook for `CS2113T`, you can add a `section`!


<br>

##### 3.4.1.2 Adding a section

Use the `add /s` command to add a `section`  into the [selected](#342-selecting-a-notebooksectionpage-select) `notebook`.

>:bulb: You must select a `notebook` before adding a section!
>
> :warning: Please also make sure not to use ";" in your section title!

Format: `add /s[SECTION]`

This is the parameter required in the command:

* `SECTION`: the name of the section in the selected `notebook`.

<br>

Example of usage:

Now that you have a notebook for `CS2113T`, you can make a `section` for each academic week.

> :bulb: Remember to select the `CS2113T` notebook!

```
>>> add /sW1: Java
Added section with title: W1: Java
```

>:warning: Ensure that your section title is preceded by "/s", or an error message will be shown.

Great! You can now add a `page` (or as many pages as you like) into your new section titled `W1: Java`.

<br>

##### 3.4.1.3 Adding a page

Use the `add /p` command to add a `page`  into the [selected](#342-selecting-a-notebooksectionpage-select) `section`.
>:bulb: You must select a `section` before adding a page!
>
> :warning: Please also make sure not to use ";" in your page title! ";" should only be used to 
> separate the page title from its contents.

Format: `add /p[PAGE]; [PAGE CONTENT]`

These are the parameters required in the command:

* `PAGE`: the name of the page in the selected `section`.
* `PAGE CONTENT`: the contents that you would like to store in the `page`.

<br>

Example of usage:

Let's say you want to add a page into a selected notebook `section`.

> :bulb: Remember to select the `W1: Java` section!

```
>>> add /pHELLO WORLD; System.out.println("Hello World!");
Added page with title: HELLO WORLD
```

You've successfully added a new page into the section `W1: Java` of the notebook `CS2113T`.

>:warning: Ensure that your page title is preceded by "/p" and that there is a ";" to separate the contents from the page title.
> Otherwise, an error message will be shown. 


<br>

#### 3.4.2 Selecting a notebook/section/page: `select`

After adding a `notebook`, `section` or `page`, you may want to view its contents.
Use the `select` command to select a `notebook`, `section`, `page` or a combination of the three.

> :bulb: When you want to [`add` a `section`](#3412-adding-a-section), you must select a `notebook` first.
>
> :bulb: When you want to [`add` a `page`](#3413-adding-a-page), you must select a `section` first.

Format: `select /n[NOTEBOOK] /s[SECTION] /p[PAGE]`

These are the parameters required in the command:

* `NOTEBOOK`: the title of the expected `notebook`.
* `SECTION`: the title of the expected `section` in `notebook`.
* `PAGE`: the page title in the expected `section`.

In *NOTEBOOK MODE*:
* `select /nCS2101 /sW2 /pEmails` - selects the page titled `Emails` in the notebook `CS2101`, under the section `W2`.
* `select /nCS2101 /sW2` - selects the section titled `W2` in the notebook `CS2101`.
* `select /nCS2101` - selects the notebook titled `CS2101`.
* `select /all` - navigates back into `NOTEBOOK MODE`, where you can list to see all available notebooks.
> These commands can be run anywhere(i.e in a selected notebook or section) once you're in NOTEBOOK MODE.  

In a selected *NOTEBOOK*:
* `select /s1: What is OOP? /pDefinition` - selects the page titled `Definition`, in the section `1: What is OOP?` of the selected `notebook`.
* `select /s1: What is OOP?` - selects the section entitled `1: What is OOP?` in the selected `notebook`.

In a selected *SECTION*:
* `select /pDefinition` - selects the page titled `Definition` in the selected `section`.

> :bulb: Whenever you want to select something, you may want to use the list all function, `list /a`
> to ensure that you're typing in the correct parameters.

<br>

Example of usage:
If you have a notebook entitled `CS2101`, you can select it by typing `select /nCS2101`.

```
>>> select /nCS2101
now in notebook book: CS2101
```

<br>

#### 3.4.3 Tagging a notebook/section/page: `tag`

You have now several notebooks in the bookshelf. Some come from the same module, while others are just a running list of
inspirations you have.

This command lets you add a single `tag` to a selected `notebook`, `section` or `tag` to remind you of the category it
belongs to. You can learn how to search for all notebooks, sections and pages in the bookshelf with the same `tag` in
[Finding notebooks](#345-finding-contents-find).

>:exclamation: The tag is added to the selected notebook, section or page. The tag will not be added to components
>belonging to the selected notebook or section are not tagged.
>
>:bulb: Each notebook, section and page can only have one tag. The previous tag will be automatically overwritten
>by the new tag and no reminder will be given.
>
Format: `tag /t[TAG]`

These are the parameters required in the command:

* `TAG`: text description of the tag

<br>

Example of usage:
For example, you would to add a tag "Module" to a notebook titled "CS2101":

>:bulb: Remember to select the notebook "CS2101"!
>
```
>>> tag /tModule
Got it! I've tagged this as:
CS2101 (tag: Module)
```

#### 3.4.4 Listing contents: `list`

Use the `list` command to view the content of the bookshelf, a selected book or a selected section.

Format: `list (/s) (/a)`

- `list` display contents in one level below the current selected object
- `list /s` display the notebooks together with titles of sections in NOTEBOOK mode
- `list /a` display all notebooks, sections and pages.

In *NOTEBOOK MODE*,
- `list` displays the titles of notebooks in the shelf.
- `list /s` displays the titles of notebooks together with titles of sections.
- `list /a` displays all notebooks, sections and pages.

<br>

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

<br>

In a selected *NOTEBOOK*:
- `list` displays the titles of all the sections in the selected notebook.
- `list /a` displays all sections and pages in the selected notebook.

<br>

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

<br>

In a selected *SECTION*:
- `list` displays all the pages in the selected section.

<br>

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

<br>

#### 3.4.5 Finding contents: `find`

Just like how you can find a task in the Timetable mode, you can look for contents in this mode. Even sections and pages
that do not belong to a select notebook can be found. There are two ways to do so:

##### 3.4.5.1 Finding by keyword

Finds all notebooks, sections and pages that contain the keyword in their title.  The search is not case-sensitive.

Format: `find [KEYWORD]`

These are the parameters required in the command:

* `KEYWORD`: keyword to look for

Example of usage:
```
>>> find chapter
I've found these for keyword: chapter
Sections:
1. CS2113 |-- Chapter 1
2. CS2113 |-- Chapter 2
3. CS2101 |-- Chapter 1
4. CS2101 |-- Chapter 2
5. CS2101 |-- Chapter 3
```
>:bulb: "|--" indicates "belongs to". You can use this to identify the particular notebook and section a page is in.


##### 3.4.5.2 Finding by tag

Finds all notebooks, sections and pages that has a specified tag.  The search is case-sensitive.

Format: `find /t[TAG]`

These are the parameters required in the command:

* `TAG`: tag to look for

Example of usage:
```
>>> find /tModule
I've found these for tag: Module
Notebooks:
1. CS2113
```

#### 3.4.6 Deleting a notebook/section/page: `delete`

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

<br>

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

<br>

### 3.5 Exiting the program: `exit`

To close the program, type `exit`.

<br>

## 4. FAQ

This section answers some frequently asked questions.

### How do I transfer my data to another computer?

The save files for Zer0Note are stored in the same directory as the Zer0Note JAR file. You may move the entire
directory to another computer and Zer0Note will continue to work with your saved data. Alternatively, you may move
just the files named `nameOfUser.txt`, `notebooks.txt` and `tasks.txt` to another computer, into the directory
containing the Zer0Note JAR file on that computer. 

### Where do I find the release? 

You can find it [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases). 

### I found a bug! Where do I report it?

Oh no! We tried to make Zer0Note as bug-free as possible, but sadly, we may have missed some. Please add an issue to
our issue tracker [on GitHub over here](https://github.com/AY2021S1-CS2113T-T12-3/tp/issues), and we will attempt to
fix it as soon as possible. 

### I have a feature idea for Zer0Note! Can I suggest it to the developers?

Thank you for using Zer0Note, we're glad you have a feature idea! Please submit it to 
[our issue tracker](https://github.com/AY2021S1-CS2113T-T12-3/tp/issues) as well. While we cannot guarantee that we
will implement your suggestion (sorry!) we will read all suggestions and consider them for future updates. 

### How does Zer0Note work under the hood?

We're delighted that you're curious about how Zer0Note works! Our code is fully open-source and can be accessed [on
our GitHub repository](https://github.com/AY2021S1-CS2113T-T12-3/tp). We recommend you read our 
[Developer Guide](https://ay2021s1-cs2113t-t12-3.github.io/tp/DeveloperGuide.html) to better understand the code, 
especially if you want to contribute to development. 

<br>

## 5. Command Summary

This section lists all the commands available in **Zer0Note**! There are general commands that can be used anywhere, as well as commands that are specific to the mode you are in!

> :bulb: You can click on each of the commands to navigate to its section.

### General Commands

The following table shows you a list of commands that can be used anywhere, and in any mode.

*Table 2: Commands that can be used anywhere*

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Help](#31-viewing-the-user-guide-help): `help` | 1) help 2) help timetable 3) help notebook |
[Exit](#35-exiting-the-program-exit) `exit` | exit |


### Timetable Mode

The following table is a cheatsheet of the commands available in Timetable Mode.

*Table 3: Cheatsheet of the commands available in Timetable Mode*

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add a task](#331-adding-a-task-add): `add` | add /t[TASK] /by[dd-MM-yyyy] [hhmm] | add /tcoding /by19-10-2020 1705
[Mark a task as done](#332-marking-a-task-as-done-done): `done` | done [INDEX] | done 1
[Tag a task](#333-tagging-tasks-tag): `tag` | tag [INDEX] /t[TAG] | tag 1 /tCS2113T
[List tasks](#334-listing-tasks-list): `list` | list (/u) (/d) (/urgent) |
[Finding tasks](#335-finding-tasks-find): `find` | 1) find [KEYWORD] 2) find /t[TAG] | 1) find book 2) find /tTodo
[Delete a task](#336-deleting-a-task-delete): `delete` | delete [INDEX] | delete 1
[Switch to notebook mode](#32-switching-between-the-two-modes-mode): `mode` | mode /n |

### Notebook Mode

The following table is a cheatsheet of the commands available in Notebook Mode.

*Table 4: Cheatsheet of the commands available in Notebook Mode*

**Command** | **Format** | **Example**
----------- | ---------- | -----------
[Add](#341-adding-a-notebooksectionpage-add): `add` | 1) add /n[NOTEBOOK] 2) add /s[SECTION] 3) add /p[PAGE]; [CONTENT] | add /nCS2101
[Select](#342-selecting-a-notebooksectionpage-select): `select` | 1) select /n[NOTEBOOK] 2) select /s[SECTION] 3) select /p[NUMBER] | select /nCS2101
[Tag](#343-tagging-a-notebooksectionpage-tag): `tag` | tag /t[TAG] | tag /tCS2113T
[List contents](#344-listing-contents-list): `list` | list (/s) (/a) |
[Find](#345-finding-contents-find): `find` | 1) find [KEYWORD] 2) find /t[TAG] | 1) find chapter 2) find /tModule
[Delete](#346-deleting-a-notebooksectionpage-delete): `delete` | 1) delete /n[NOTEBOOK] /s[SECTION] /p[NUMBER] | select /nCS2113T /sW10 /p1
[Switch to timetable mode](#32-switching-between-the-two-modes-mode): `mode` | mode /t |

<br>

## 6. For advanced users: Editing your save file

**Zer0Note** saves your tasks as a plain text file, in a format designed to be easy to read, understand and modify if
you so desire. We realise that power users may wish to use a different text editor such as vim or Visual Studio Code
to edit their notes, while also taking advantage of the organisation features of Zer0Note. If you wish to edit the
save file by yourself, here's a detailed guide on the contents of the save file and how to edit it.

> :exclamation: **Zer0Note** is very sensitive to the format of the saved file! If there are any errors in the save
> file, **Zer0Note** will not load it at all, since it cannot be sure if any of the file is uncorrupted. Proceed with
> caution!

<br>

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

<br>

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
