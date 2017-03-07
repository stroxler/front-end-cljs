# cc-vids

## Video 1

The first commit on this repo is from the end of a mildly-css-styled
variant of [video 1](https://www.youtube.com/watch?v=DkcCfDG8ytE) from
the CodeCademy, which covers very basic html:
 * document and body, paragraphs, headers
 * links `<a>` images `<img>` unordered and ordered lists `<ul>` and `<ol>`
 * id tags and internal links

I skipped a few minor notes like using `<&lt;>` to get a literal `<` in
html. I also skipped comments, since that's irrelevant when using hiccup +
reagent.

## Video 2

Work through [video 2](https://www.youtube.com/watch?v=EiDxEG3wFx4), a
basic css intro.

Intro to basics of css: some specific rules for various types of elements
(especially text), and also some fall-through rules.

Also demo some of garden's syntax, especially in the nested `<ul>` rule, and
explored the semantics of html margins.

## Video 3 and 4

Videos [3](https://www.youtube.com/watch?v=xc9LB9XunJ0&t=6s) and
[4](https://www.youtube.com/watch?v=hWshdGJF5wo) actually largely cover things
that are either uninteresting or that I already partially covered in earlier
work. So, while tagging along, I mostly tweak some things:
  - adjusted the margin / padding so that the heading and nav divs span
    the screen.
  - pick a better heading background image, and set it to fill
  - tweak the nav links to be a little better formatted, although they are
    still kind of ugly to be honest; I'm still not sure a good way to space
    them
  - use borders and such a bit more to make the page slightly fancier and make
    my css better as an example to refer back to

The one really valuable thing in lesson 4, that I don't really cover in the
code but want to add to the notes, is the 
[box model](https://www.w3schools.com/css/css_boxmodel.asp):
  - content goes in a div (or other block element), and takes up however
    much room it takes up
      - if you put stuff in, then by default the content is as small as
        possible
      - if you specify width and/or height, that determines the dimensions
        of the content (but not the content + padding or whatever else)
  - around that content is a padding, which is *inside* the block element
    but outside of the content area. It doesn't count toward the width
    or height, but if you give e.g. a background, the background style will
    apply to the padding as well as content
  - around the padding is a border. Background styles on the block element
    won't apply to the border, but border styles will
  - around the border is a margin. You cannot modify the margin by modifying
    styles on the element, but the margins determin position relative to
    other elements inside the parent block element.

Another thing I wanted to note was sizings: an em is the width of an m in
the default document text font size, and these days it's considered good
practice to use sizing in ems because they are more invariant to screen size,
and more mobile-friendly, than using e.g. px.

## More videos

At the time I started this project, my impression was that there were only 4
videos, but it actually turns out there are 9. I've had about enough at this
point, and want to move on to more focused front-end tutorials that will
help me learn some combination of
  - how to make real professional-grade websites (maybe - this isn't a major
    focus for me)
  - how to make practical informational / administrative UIs for relatively
    simple software systems - this is my main focus, since my work involves
    managing artifacts / clusters / services / logs / jobs etc, and if I
    weren't doing that I'd be doing data science and building statistical
    dashboards
