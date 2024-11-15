#!/usr/bin/env bash

# Run from root
# Example usage: ./scripts/generate.sh 2022 01

set -Eeuo pipefail
set -x

val_of_key() {
    case $1 in
        '2021') echo 'twentytwentyone';;
        '2022') echo 'twentytwentytwo';;
        '2023') echo 'twentytwentythree';;
        '2024') echo 'twentytwentyfour';;
    esac
}

year=$1
day=$2
year_string=$(val_of_key "$year")

echo "year: $year"
echo "day: $day"
echo "$year_string"

search="Template"
replace="Day${day}"

lower_replace=$(echo "$replace" | tr '[:upper:]' '[:lower:]')
lower_search=$(echo "$search" | tr '[:upper:]' '[:lower:]')

# Generate Class from template
template_location="src/main/kotlin/common/Template.kt"
input_file_location="src/main/kotlin/$year_string/inputs/$lower_replace.txt"
destination_location="src/main/kotlin/$year_string/$replace.kt"

touch $input_file_location
sed "s/$search/$replace/g" $template_location > $destination_location
sed -i '' "s/package common/package $year_string/" $destination_location
sed -i '' "s/yearstring/$year_string/" $destination_location
sed -i '' "s/$lower_search/$lower_replace/" $destination_location

# Generate Test Class from template
test_template_location="src/test/kotlin/common/TemplateTest.kt"
test_destination_location="src/test/kotlin/$year_string/${replace}Test.kt"

sed "s/$search/$replace/g" $test_template_location > $test_destination_location
sed -i '' "s/package common/package $year_string/" $test_destination_location
sed -i '' "s/$lower_search/$lower_replace/" $test_destination_location
