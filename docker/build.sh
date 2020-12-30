#!/usr/bin/env bash

cd $(dirname "${BASH_SOURCE[0]}")/..
set -e

docker build  -t springcrypto/wallet -f ./docker/Dockerfile .
