Learning basic front end (how to make decent pages with
html and css) via clojurescript, reagent and garden.

Why use clojurescript rather than just coding html?
Because
  * I generally want to learn clojurescript and clojure, the
    language and community appeals to me
  * The thing I need to learn is the *concepts* of html and css;
    the syntax isn't a challenge
  * Clojurescript + figwheel gives hot-reloading, which I wouldn't
    easily get by going through intro html/css tutorials manually

Inside this repo I'm going to create some clojurescript projects
tagging along with various videos / blog posts / online tutorials
and courses about basic html and css, but I'll be translating them
into reagent and garden.

# Starter

The starter clode in `starter` is the original code for cc-vids,
once I had garden hooked up.

To start a new html / css tutorial from scratch, all you need to do
is start editing `views.cljs` with hiccup html syntax, and `style.cljs`
with garden css syntax.
