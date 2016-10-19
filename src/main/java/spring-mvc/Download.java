/// fragment
@RequestMapping("/books/down")
    public void getFile(HttpServletResponse resp) throws Exception {
        resp.setContentType("application/zip");
        resp.setHeader("Content-Disposition", "attachment; filename=tt.zip");
        InputStream is = new FileInputStream("/tmp/aaa/tt.zip");
        FileCopyUtils.copy(is, resp.getOutputStream());
        resp.flushBuffer();
    }
