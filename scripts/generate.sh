#!/usr/bin/env bash

# Run from root
# Example usage: ./scripts/generate.sh 2022 01

set -Eeuo pipefail
set -x

script_dir=$(cd "$(dirname "${BASH_SOURCE[0]}")" &>/dev/null && pwd -P)

year=$1
day=$2

echo "year: ${year}"
echo "day: ${day}"

URL="https://adventofcode.com/${year}/day/${day}/input"

echo $URL

echo $PWD

#wget -O "./src/main/kotlin/twentytwentytwo/inputs/day${day}.txt" $URL


search="Template"
replace="Day${day}"


lower_replace=$(echo "$replace" | tr '[:upper:]' '[:lower:]')
lower_search=$(echo "$search" | tr '[:upper:]' '[:lower:]')

echo $lower_replace

template_location="src/main/kotlin/common/Template.kt"
destination_location="src/main/kotlin/twentytwentytwo/${replace}.kt"

test_template_location="src/test/kotlin/common/TemplateTest.kt"
test_destination_location="src/test/kotlin/twentytwentytwo/${replace}Test.kt"

sed "s/$search/$replace/g" $template_location > $destination_location
sed -i '' 's/package common/package twentytwentytwo/' $destination_location
sed -i '' "s/$lower_search/$lower_replace/" $destination_location

sed "s/$search/$replace/g" $test_template_location > $test_destination_location
sed -i '' 's/package common/package twentytwentytwo/' $test_destination_location
sed -i '' "s/$lower_search/$lower_replace/" $test_destination_location
