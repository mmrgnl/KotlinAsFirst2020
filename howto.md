###### **Отчет по домашнему заданию (практике GIT)**


1. Сделал форк https://github.com/Kotlin-Polytech/KotlinAsFirst2020
2. Создал клон проекта
3. Добавил upstream ``` git remote add upstream-my https://github.com/mmrgnl/KotlinAsFirst2021 ```
4. Произвел fetch ```git fetch upstream-my```
5. Создал и прешел в ветку backport ``` git checkout -b backport```
6. Перенес в нее свои коммиты ```git cherry-pick d535f3592006b8f2593c9f881d72c05164aadc13...FETCH_HEAD```
7. Добавляю репозиторий моего коллеги (Рубцов Евгений Александрович)
 ```git remote add upstream-theirs https://github.com/TheDark1ord/KotlinAsFirst2021```
8. Загружаю коммиты ``` git fetch upstream-theirs```
9. Решаю конфликты ```git status```   ```git add/rm <file>```
10. Произвожу merge ```$ git merge -X ours upstream-theirs/master```
11. Создаю и коммичу remotes ```git remotes -v > remotes```
```git remotes -v > remotes```
```git add remotes```
```git commit```
12. Создаю howto.md и описываю практику 