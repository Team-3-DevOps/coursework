# USE CASE: Produce a Report on The top N populated capital cities in the world, continent or region, where N is provided by the user
## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user*, I want *to produce a report on The top N populated capital cities in the world where N is provided by the user* so that *I can easily know the rank of the population of capital cities in the world, continent or a region.*

### Scope

Team-3 DevOps Project.

### Level

Primary task.

### Preconditions

Users have to input a number. Database contains current capital cities' data.

### Success End Condition

A report is available for user to view the countries' data by a given rank.

### Failed End Condition

No report is produced.

### Primary Actor

the user

### Trigger

the user's request.

## MAIN SUCCESS SCENARIO

1. user request capital cities information for in a specific area (world, continent or region) by a given rank
2. The system captures the number of rank to get capital cities information for.
3. The system extracts current population information of all capital cities of the given area.
4. The system provides report to the user.

## EXTENSIONS

None

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 5.0