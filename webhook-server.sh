#!/bin/sh
cd "$(dirname "$0")"
webhook -hooks hooks.json -hotreload -logfile webhooks.log
cd -
