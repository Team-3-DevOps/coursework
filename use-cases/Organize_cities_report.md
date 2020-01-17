# USE CASE: Produce a Report on the cities in the world, continent, region, country or district by largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user*, I want *to produce a report on the cities in the world, continent, a region, country or district by largest to smallest* so that *I can easily know the population of countries in the world, continent or a region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

Database contains current cities' population data.

### Success End Condition

A report is available for user to view the cities' population rank.

### Failed End Condition

No report is produced.

### Primary Actor

user

### Trigger

the user's request.

## MAIN SUCCESS SCENARIO

1. user request to organize cities in a given area (world, continent , region, country or district) by population
2. The system captures name of the area to get cities' information for.
3. The system extracts current population information of all cities of the given area.
4. The system provides report by organizing cities in a given area by population to the user.

## EXTENSIONS

None

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 5.0