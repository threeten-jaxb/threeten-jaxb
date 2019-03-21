#!/usr/bin/env bash

set -o errexit

git config --global user.name "Martin Kröning (CI)"
git config --global user.email "m.kroening@hotmail.de"

pushd ..

git clone https://$GITHUB_TOKEN@github.com/threeten-jaxb/threeten-jaxb.github.io.git

popd

rm -rf ../threeten-jaxb.github.io/*/javadoc

for project in threeten-jaxb-*/; do
    mkdir -p ../threeten-jaxb.github.io/${project}javadoc/
    cp -r ${project}/build/docs/javadoc/ ../threeten-jaxb.github.io/${project}javadoc/
done

commit=$(git rev-parse --short HEAD)

cd ../threeten-jaxb.github.io

git add --all
git commit -m "Update Javadoc from threeten-jaxb commit $commit"
git push
