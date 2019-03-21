#!/usr/bin/env bash

set -o errexit

pushd ..

git clone https://github.com/threeten-jaxb/threeten-jaxb.github.io.git <<END
$GITHUB_USERNAME
$GITHUB_TOKEN
END

popd

rm -rf ../threeten-jaxb.github.io/*/javadoc

for project in threeten-jaxb-*/; do
    cp -r $project/build/docs/javadoc/ ../threeten-jaxb.github.io/$project/javadoc/
done

commit=$(git rev-parse --short HEAD)

cd ../threeten-jaxb.github.io

git add --all
git commit -m "Update Javadoc from threeten-jaxb commit $commit"
git push
