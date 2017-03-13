# vexflow-demo

## Creating it

I started from the starter, and added a second div with id "vex" to my
index.html page.

Then I ran - based on the vexflow [README](https://github.com/0xfe/vexflow),
```
mkdir -p src/js
curl -o src/js/vexflow-min.js https://unpkg.com/vexflow@1.2.83/releases/vexflow-min.js
curl -o src/js/vexflow-dbg.js https://unpkg.com/vexflow@1.2.83/releases/vexflow-debug.js
```

Next, I added  the following configuration to both my dev and min builds
in `project.clj`:
```
:foreign-libs [{:file "src/js/vexflow-dbg.js"
                :file-min "src/js/vexflow-min.js"
                :provides ["Vex"]
                :module-type :commonjs}]
```

This was enough to make dev mode work. I don't yet know whether I might need
an externs file in order to use advanced compilation optimization.
