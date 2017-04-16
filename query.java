Connection cn = null;
try {
  cn = AccesoDB.getConnection();

} catch (SQLException e) {
  throw new RuntimeException("Error BD: " + e.getMessage());
} catch (EurekaException e) {
  throw new RuntimeException("Error App: " + e.getMessage());
} catch (Exception e) {
  throw new RuntimeException("Error: " + e.getMessage());
} finally{
  try {
	cn.close();
  } catch (Exception e) {
  }
}