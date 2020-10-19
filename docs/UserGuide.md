# User Guide

## Navigation Panel
- [Quick Start](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#quick-start)
- [Features](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#features)
  - [Mode Switch](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#mode-switch)
  - [Timetable Mode](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#timetable-mode)
    - [Add a `task`](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#adding-a-task)
  - [Notebook Mode](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#notebook-mode)
    - [Add a `notebook`](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#adding-a-notebook)
    - [Add a `section`](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#adding-a-section)
    - [Add a `page`](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#adding-a-page)
    - [`Select`](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#select)
- [Command Summary](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#command-summary)

## Introduction

Zer0Note is a note taking and organisation application that combines the ease of use and feature set of graphical tools with the interaction speed of command-line based tools like vim and emacs.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Zer0Note` from [here](https://github.com/AY2021S1-CS2113T-T12-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Zer0Note.
4. Double click the file to start the app.
5. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window.

## Features

{Give detailed description of each feature}
>:exclamation: Words within `[square brackets]` are the expected user inputs.
>> e.g. in `add /n[NOTEBOOK]`, `NOTEBOOK` is a parameter which can be used as `add /n`

## Timetable Mode
In `Timetable` mode, you can...

### Adding a task
Adds a `task` with a `deadline` to the task list.

Format: `add /t[task] /by[dd/MM/yyyy] [hhmm]`

* `task`: name of the task.
* `dd/MM/yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

Example of usage:
`add /tcoding /by19-10-2020 1900`

Expected output:
`Added: coding
1:[x] coding (by: Oct 19 2020 07.00 PM)`

## Notebook Mode
In `Notebook mode`, you can...

### Adding a notebook
Adds a `notebook`  into the `notebook shelf`.

Format: `add /n[NOTEBOOK]`

* `NOTEBOOK`: the name of the notebook.

Example of usage:
`add /nCS2101`

Expected output:
`Added notebook with title: CS2101`

### Adding a section
Adds a `section`  into the [selected](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#select) `notebook`.
>:exclamation: You must select a `notebook` before adding a section!

Format: `add /s[SECTION]`

* `SECTION`: the name of the section in the selected `notebook`.

Example of usage:
`add /sW1: Java`

Expected output:
`Added section with title: W1: Java`

### Adding a page
Adds a `page`  into the [selected](https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html/#select) `section`.
>:exclamation: You must select a `section` before adding a page!

Format: `add /p[PAGE]; [PAGE CONTENT]`

* `PAGE`: the name of the page in the selected `section`.
* `PAGE CONTENT`: the contents that you would like to store in the `page`.

Example of usage:
`add /pHELLO WORLD; System.out.println("Hello World!");`

Expected output:
`Added page with title: HELLO WORLD`

### Select
Select a `notebook`, `section`, `page` or a combination of the three.

Format: `select /n[NOTEBOOK] /s[SECTION] /p[NUMBER]`

* `NOTEBOOK`: the title of the expected `notebook`.
* `SECTION`: the title of the expected `section` in `notebook`.
* `PAGE`: the page number in the expected `section`.

Examples of usage:
In *NOTEBOOK MODE*,
* `select /nCS2101 /sW2 /p1` - selects page 1 in the notebook `CS2101`, under the section `W2`.
* `select /nCS2101 /sW2` - selects section entitled `W2` in the notebook `CS2101`.
* `select /nCS2101` - selects the notebook entitled `CS2101`.
* `select /all` - navigates back into `NOTEBOOK MODE`, where you can list to see all available notebooks.
> These commands can be run anywhere(i.e in a selected notebook or section) once you're in NOTEBOOK MODE.  

In a selected *NOTEBOOK*,
* `select /s1: What is OOP? /p1` - selects page 1 in the section `1: What is OOP?`, in the selected `notebook`.
* `select /s1: What is OOP?` - selects the section entitled `1: What is OOP?` in the selected `notebook`.

In a selected *SECTION*,
* `select /p1` - selects page 1 in the selected `section`.

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## Command Summary
{Give a 'cheat sheet' of commands here}

**Command** | **Format** | **Example**
----------- | ---------- | -----------
*TIMETABLE MODE* `add` | add /tTASK /by[dd/MM/yyyy] [hhmm] | add /tcoding /by19-10-2020 1705
*NOTEBOOK MODE* `add` | 1) add /nNOTEBOOK 2) add /sSECTION 3) add /pPAGE; CONTENT | add /nCS2101
*NOTEBOOK MODE* `select` | 1) select /nNOTEBOOK 2) select /sSECTION 3) select /pNUMBER 4) select /nNOTEBOOK /sSECTION /pNUMBER | select /nCS2101
