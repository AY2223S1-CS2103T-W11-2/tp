---
layout: page
title: User Guide
---

---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start



--------------------------------------------------------------------------------------------------------------------

## Features

### View your teaching schedule: `view schedule`

**Syntax**: `view schedule [-w WEEKDAY] [-m MODULE_CODE] [-d DATE] [-h] [-v]`

- `-w WEEKDAY` option shows your schedule on the `WEEKDAY`. `WEEKDAY` should be one of `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday` and `Sunday`.
- `-m MODULE_NAME` option shows your weekly schedule of `MODULE_CODE`.
- `-d DATE` option shows your schedule on the `DATE`. `DATE` should comply with the format `yyyy-mm-dd`
- `-h` option shows your schedule table in a horizontal mode (time will be columns and weekdays will be rows).
- `-v` options shows your schedule table in a vertical mode (weekdays will be columns and time will be rows).
- The result will be a timetable in vertical mode by default if no option is specified.

**Notes about the syntax**:

- `-w WEEKDAY` option and `-d DATE` option cannot be used at the same time.
- If either `-w WEEKDAY`, `-m MODULE_NAME` or `-d DATE` is used, the result won't be a timetable. Instead, it will be shown as a list of slots.
- `-h` and `-v` options can only be used when the result is shown as a timetable.
- `-h` option and `-v` option cannot be used at the same time.

**Examples**:

- `view schedule -w Monday -m CS2103T`

  <div align=center><img src="./images/view schedule -w Monday -m CS2103T.png" width=300px></div>

- `view schedule -d 2022-09-12`

  <div align=center><img src="./images/view schedule -d 2022-09-12.png" width=300px></div>

- `view schedule -h` 

  <div align=center><img src="./images/view schedule -h.png" width=500px height=250px></div>



### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action     | Format, Examples                                             |
| ---------- | ------------------------------------------------------------ |
| **Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **Clear**  | `clear`                                                      |
| **Delete** | `delete INDEX`<br> e.g., `delete 3`                          |
| **Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com` |
| **Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`   |
| **List**   | `list`                                                       |
| **Help**   | `help`                                                       |
