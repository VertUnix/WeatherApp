**git init** \
**git remote add origin** https://github.com/VertUnix/WeatherApp \
**git config --global user.email [e_mail]**\
**git config --global user.name [un_username]**\
**git checkout -b** [nume_branch]   = creeaza branch nou local\
**git branch -a** = afiseaza toate branch-urile (locale si remote); daca nu s-a facut niciun pull inca, e posibil sa nu se afiseze nimic \
**git pull origin [nume_branch]**  = copiaza branch-ul [nume_branch] in branch-ul local selectat (ala albastru)\
**git branch --set-upstream-to=origin/[branch_remote] [branch_local]** = leaga branchul local de cel remote pt viitoarele push-uri \
**git checkout [nume_branch]**   = ma mut pe un anumit branch\
**git status**  = vezi ce fisiere ai modificat față de repository-ul original\
**git add** [nume fisier pe care dorim sa-l includem]\
**git add .**    = adauga toate fisierele/ subfolderele din folderul la commit (in git status cele modificate vor aparea cu verde, adica sunt pregatite sa fie incarcate pe server)\
**git commit -s**   = pregateste un commit (afiseaza editorul text undde scriu descrierea commit-ului); optiunea *-s* include "semnatura" autorului\
**git push**    = uploadeaza commit-ul in repo\

Altele:
**git push -u origin my-branch-name** = creeaza branch-ul my-branch-name (deja existent local) si in repo-ul remote si face push
**git push -u origin HEAD** = branch-ul pe care ma aflu in prezent; comanda echivalenta cu cea de mai sus
**git clone** https://github.com/VertUnix/TreasureHunt \  = cloneaza in directorul de lucru un repo remote deja existent


#### ====FETCH/ PULL/ MERGE====

**git pull = git fetch + git merge**.
git pull will always merge into the *current branch*

GIT FETCH: You can do a git fetch at any time to update your remote-tracking branches under refs/remotes/<remote>/. This operation never changes any of your own local branches under refs/heads, and is safe to do without changing your working copy.

When you fetch, Git gathers any commits from the target branch that do not exist in your current branch and stores them in your local repository. However, it does not merge them with your current branch.

![uml_secvential](https://i.stack.imgur.com/XwVzT.png)


