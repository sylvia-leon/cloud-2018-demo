@echo off
git add . 
git commit -a -m "auto commit";
git pull origin
git checkout master
git pull origin
git merge --no-ff dev
git checkout cloud
git pull origin
git merge --no-ff master
git checkout dev
git push --all
