#! /bin/bash

ls -la | awk '{print $9;}' | xargs du -sh