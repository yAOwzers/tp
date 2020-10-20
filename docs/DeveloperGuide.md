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

## Setting up
### Prerequisites
1. **JDK** 11
2. **IntelliJ** IDEA

### Setting up the project in your computer
>:exclamation **Caution:** Follow the steps in the following guide precisely.
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

### Verifying the setup
1. Run the `seedu.duke.Duke`.
2. Try a few commands.
3. [Run the tests] to ensure they all pass.

### Configure the coding style
If using IDEA, follow the guide [[se-edu/guides] IDEA: Configuring the code style](https://se-education.org/guides/tutorials/intellijCodeStyle.html) 
to set up IDEA’s coding style to match ours.

>Optionally, you can follow the guide [[se-edu/guides] Using Checkstyle](https://se-education.org/guides/tutorials/checkstyle.html) 
>to find how to use the CheckStyle within IDEA e.g., to report problems as you write code.

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
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
{Recommend software we use to draw UML diagrams}

### Converting a document to the PDF Format
We use **Chrome** for converting documentation to PDF format.
> Reason: CHrome's PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
2. Within Chrome, click on the `Print` option in Chrome’s menu.
3. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format.
For best results, use the settings indicated in the screenshot below.
<img src=https://se-education.org/guides/tutorials/images/chrome_save_as_pdf.png>

|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
