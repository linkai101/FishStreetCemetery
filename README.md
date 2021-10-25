# Fish Street Cemetery
Linkai Wu (PD2)

## Overview
A directory of burials in Fish Street Cemetery.
- Display all burials
- Display burial count
- Lookup burials by date
- Lookup burials by date range (optional: specify address)

## Installation
1. Set up the program with your IDE, all core files are in `src/wu/linkai`. (original program was set up in IntelliJ IDEA)
2. Run the java file at `src/wu/linkai/FishStreet.java` (or respective file in your setup)
3. That's it!

## User interface
- The main menu looks like the following. Type the value within the `()` and press Enter to select the respective option.
```
Fish Street Cemetery Directory
(1) Lookup by date
(2) Lookup by date range
(3) All burials
(4) Burial count
(exit) Exit program
>>>
```

- Based on the option you selected, you may be prompted for additional input.
- **Lookup by date** *(1)*
  + Search and list all burial records on specified date
  + Month `m:` (e.g. `12`, `Dec`)
  + Day `d:` (e.g. `15`)
  + Year `y:` (e.g. `1824`)
  ```
  >>> 1
  Lookup by date
    m: 12
    d: 15
    y: 1824
  Search results for 12/15/1824:
    - Ann WHIFFEN 12/15/1824 42.0 St Peter's Hill
  ```  
  
- **Lookup by date range** *(2)*
  + Search and list all burial records within specified timeframe.
  + start date
    * Month `m:` (e.g. `12`, `Dec`)
    * Day `d:` (e.g. `15`)
    * Year `y:` (e.g. `1824`)
  + end date
    * Month `m:` (e.g. `12`, `Dec`)
    * Day `d:` (e.g. `15`)
    * Year `y:` (e.g. `1824`)
  + address (optional filter, press enter to skip)
    + (e.g. `Knight Rider Court`)
  ```
  >>> 2
  Lookup by date range
  start date:
    m: Mar
    d: 25
    y: 1838
  end date:
    m: 2
    d: 23
    y: 1840
  (optional) address: Old Fish Street
  Search results at Old Fish Street from 3/25/1838 to 2/23/1840:
    - Stephen PERKINS 3/25/1838 19.0 Old Fish Street
    - Sarah WELCH 2/23/1840 20.0 Old Fish Street
    - Sarah WELCH 2/23/1840 20.0 Old Fish Street
   ```
- All burials *(3)*
  + Lists out every burial record from Fish Street Cemetery.
  + (might be very long!)
  ```
  >>> 3
  All burials
  - Robert Joseph DYSON 1/5/1813 6.000000000000001 Old Change
  - James HINES 1/17/1813 40.0 Lambeth Hill
  - William STEDMAN 2/17/1813 5.833333333333333 Crane Court
  - Mary LANGDON 3/15/1813 36.0 Blackheath Hill Kent
  - Richard Ann SMITH 4/1/1813 2.5 Lambeth Hill
  - Isabella CLARK 4/8/1813 0.019178082191780823 Little Knight Ryder Street
    ...
  ```
  
- Burial count *(4)*
  + Returns the burial population of the cemetery.
  ```
  >>> 4
  Burial count: 563
  ```
  
- Exit *(exit)*
  + Stops the program