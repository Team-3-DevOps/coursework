# USE CASE: Produce a Report on The top N populated cities in the world, continent, region, country or district, where N is provided by the user
## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user*, I want *to produce a report on The top N populated cities in the world where N is provided by the user* so that *I can easily know the rank of the population of cities in the world, continent, region, country or district.*

### Scope

Team-3 DevOps Project.

### Level

Primary task.

### Preconditions

Users have to input a number . Database contains current cities' data.

### Success End Condition

A report is available for user to view the cities' data by a given rank.

### Failed End Condition

No report is produced.

### Primary Actor

user

### Trigger

the user wants to.

## MAIN SUCCESS SCENARIO

1. user request cities information for in a specific area (world, continent, region, country or district) by a given rank
2. The system captures the number of rank to get cities information for.
3. The system extracts current population information of all cities of the given area.
4. The system provides report to the user.

## EXTENSIONS

None

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 5.0