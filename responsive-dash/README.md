# responsive-dash

A simple re-frame + garden application (really only garden matters here,
it's static html) illustrating creating a semi-responsive dashboard from
scratch in html.

Based loosely on [this demo](https://www.youtube.com/watch?v=oxGmXOKazw0)
video.

# Good reference for:

In terms of UI basics, this demonstrates a few things:
  - Using a flex row layout in a main section to put a nav by a content
  - Using the box model (although a better practice going forward might be
    to use the border-box feature, which makes border and padding count as
    width and height)
  - Using percentage layouts, centering, and min- and max-width to make
    a scalable UI but with limits to its scaling
  - Using transitions and :hover / .selected to control button-like UI
    features in the nav bar

I added in a css reset that I got from an intro to html.

In terms of colors, I demonstrate a decent solarized-based color theme.

# Additional color goodies

I added into styles some dictionaries of colors from:
  - FlatUIcolors.com - I originally wanted to use these, although my
    takeaway has been that you can really only use one color pair in
    a website, plus :cloud :silver :concrete and :asbestos
  - materialuicolors.co - simple bold colors, although I actually kind of
    doubt I would use most of them
  - solarized - the traditional solarized color theme colors, plus some
    additions of my own (websites need a bit more contrast, so I expanded
    the content grey color range, and I also added an offwhite)

I wound up picking a solarized color theme, because my attempt at using
two different colors from the flatuicolors page was pretty terrible - if I
ever use it again, remember that only the neutral grey / offwhite can be
mixed with one pairing of other colors. Other than that, I probably need to
just use shades of white and black, or use a color picker.

Also my takeaway from solarized is that using editor color themes might not
be a bad general strategy ha.
