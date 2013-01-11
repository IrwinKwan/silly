#!/bin/sh
# Changes permissions of all directories to be 755 and
# all files to be 644.
# Great for fixing permissions for web-viewable files.

find . -type d -exec chmod 755 {} \;
find . -type f -exec chmod 644 {} \;

