#!/usr/bin/env bash

set -e

SOURCE="${BASH_SOURCE[0]}"

echo "srouce: $SOURCE"

dir=$(dirname $SOURCE)

echo "dir $dir"

cd $(dirname "${BASH_SOURCE[0]}")/..

ls
