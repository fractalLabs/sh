# sh

A Clojure library designed to improve clojure.java.shell

## Usage

Add this dependency to your project.clj: [cj "1.0.0-SNAPSHOT"]

(use 'sh.core)

And now you can start doing stuff like:

(ls "~/Desktop")

(ls :la)

(git "status")

(lein "deps")

(wget :H "\"some-header\"" :H "\"another-header, why not\"" "fractalmedia.mx")


* If you give more than one argument, they will be concatenated with a space in between.

* If you give a keyword as an argument it will be converted this way: :keyword => -keyword


Thats kinda it.

## License

Copyright (C) 2010-2012 Fractal Media

Distributed under the Eclipse Public License, the same as Clojure.
