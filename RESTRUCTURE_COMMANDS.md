```bash
#!/usr/bin/env bash
set -e

SOURCE_ROOT="/home/faaris/Downloads/Digital-Nurture-JavaFSE-main/Java FSE/Deepskilling"
REPO_ROOT="/home/faaris/projects/cts/java-fse-upskilling"

cd "$REPO_ROOT"

if ! command -v markitdown >/dev/null 2>&1 && ! python3 -m markitdown --help >/dev/null 2>&1; then
    python3 -m pip install --user markitdown --quiet
fi

convert_file() {
    local src="$1"
    local dest_dir="$2"
    local filename
    local basename_no_ext

    filename="$(basename "$src")"
    basename_no_ext="${filename%.*}"

    if command -v markitdown >/dev/null 2>&1; then
        markitdown "$src" -o "$dest_dir/${basename_no_ext}.md"
    else
        python3 -m markitdown "$src" -o "$dest_dir/${basename_no_ext}.md"
    fi
}

copy_and_convert() {
    local src="$1"
    local dest_dir="$2"

    mkdir -p "$dest_dir"
    cp -n "$src" "$dest_dir/" || true
    convert_file "$src" "$dest_dir"
}

copy_and_convert "$SOURCE_ROOT/Engineering concepts/Design Patterns and Principles.docx" "$REPO_ROOT/week-01/design-patterns-and-principles"
copy_and_convert "$SOURCE_ROOT/Engineering concepts/Algorithms_Data Structures.docx" "$REPO_ROOT/week-01/algorithms-data-structures"
copy_and_convert "$SOURCE_ROOT/PL SQL programming/PLSQL_Exercises.docx" "$REPO_ROOT/week-02/plsql-programming"
copy_and_convert "$SOURCE_ROOT/JUnit, Mockito and SL4J/1. JUnit_Basic Testing Exercises.pdf" "$REPO_ROOT/week-02/junit-basic-testing"
copy_and_convert "$SOURCE_ROOT/JUnit, Mockito and SL4J/3. Mockito exercises.pdf" "$REPO_ROOT/week-02/mockito-exercises"
copy_and_convert "$SOURCE_ROOT/JUnit, Mockito and SL4J/6. SL4J Logging exercises.pdf" "$REPO_ROOT/week-02/slf4j-logging-framework"
copy_and_convert "$SOURCE_ROOT/Spring Core and Maven/Spring Core_Maven.docx" "$REPO_ROOT/week-03/spring-core-maven"
copy_and_convert "$SOURCE_ROOT/Spring Data JPA with Hibernate/1. spring-data-jpa-handson.docx" "$REPO_ROOT/week-04/spring-data-jpa-with-hibernate"
copy_and_convert "$SOURCE_ROOT/Spring Data JPA with Hibernate/Spring Data JPA and Hibernate.docx" "$REPO_ROOT/week-04/spring-data-jpa-with-hibernate"
copy_and_convert "$SOURCE_ROOT/Spring Data JPA with Hibernate/2. spring-data-jpa-handson.docx" "$REPO_ROOT/week-04/spring-data-jpa-query-methods"
copy_and_convert "$SOURCE_ROOT/Spring Data JPA with Hibernate/2. spring-data-jpa-handson.docx" "$REPO_ROOT/week-04/spring-data-jpa-or-mapping"
copy_and_convert "$SOURCE_ROOT/Spring Data JPA with Hibernate/3. spring-data-jpa-handson.docx" "$REPO_ROOT/week-04/spring-data-jpa-hql-native-query"
copy_and_convert "$SOURCE_ROOT/Spring REST using Spring Boot/1. spring-rest-handson.docx" "$REPO_ROOT/week-05/spring-rest-handson-1"
copy_and_convert "$SOURCE_ROOT/Spring REST using Spring Boot/2. spring-rest-handson.docx" "$REPO_ROOT/week-05/spring-rest-handson-2"
copy_and_convert "$SOURCE_ROOT/Spring REST using Spring Boot/3. spring-rest-handson.docx" "$REPO_ROOT/week-05/spring-rest-handson-3"
copy_and_convert "$SOURCE_ROOT/Spring REST using Spring Boot/5. JWT-handson.docx" "$REPO_ROOT/week-05/jwt-handson"
copy_and_convert "$SOURCE_ROOT/Microservices/2. Microservices with API gateway.pdf" "$REPO_ROOT/week-06/microservices-with-api-gateway"

for number in {1..19}; do
    copy_and_convert "$SOURCE_ROOT/React/$number. ReactJS-HOL.docx" "$REPO_ROOT/week-07/react-hol"
done

copy_and_convert "$SOURCE_ROOT/Angular/Angular_HandsOn.pdf" "$REPO_ROOT/week-08/angular-hands-on"

for number in {1..5}; do
    copy_and_convert "$SOURCE_ROOT/GIT/$number. Git-HOL.docx" "$REPO_ROOT/week-09/git-hol"
done

rm -rf "$REPO_ROOT/week-02/plsql-control-structures"

git add -A
git commit -m "Restructure Java FSE hands-on repository" || echo "No changes to commit"
git push origin main
```