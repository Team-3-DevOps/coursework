# USE CASE: Produce a Report on the capital cities in the world, continent or a region by largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user*, I want *to produce a report on the capital cities in the world, continent or a region by largest to smallest* so that *I can easily know the population of capital cities in the world, continent or a region.*

### Scope

Organization

### Level

Primary task.

### Preconditions

Database contains current capital cities' data in table "country".

### Success End Condition

A report is available for user to view the capital cities' data.

### Failed End Condition

No report is produced.

### Primary Actor

the user

### Trigger

the user's request.

## MAIN SUCCESS SCENARIO

1. The user request to organize capital cities in a given area (world, continent or region) by population
2. The system captures name of the area to get capital cities' information for.
3. The system extracts current population information of all capital cities of the given area.
4. The system provides report by organizing capital cities in a given area by population to the user.

## EXTENSIONS

None

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 5.0